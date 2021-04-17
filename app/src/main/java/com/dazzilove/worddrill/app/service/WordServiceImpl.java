package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.WordExampleParamV1;
import com.dazzilove.worddrill.app.controller.dto.MeanParamV1;
import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.controller.dto.WordSearchParamV1;
import com.dazzilove.worddrill.app.domain.WordExample;
import com.dazzilove.worddrill.app.domain.Mean;
import com.dazzilove.worddrill.app.domain.Word;
import com.dazzilove.worddrill.app.domain.repository.mongodb.WordMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMongodbRepository wordMongodbRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Word> getList(WordSearchParamV1 wordSearchParamV1) {
        String langCode = wordSearchParamV1.getLangCode();
        String word = wordSearchParamV1.getWord();
        String mean = wordSearchParamV1.getMean();

        Query query = new Query();
        if (!"".equals(langCode))
            query.addCriteria(Criteria.where("langCode").is(langCode));
        if (!"".equals(word))
            query.addCriteria(Criteria.where("word").regex(word));
        if (!"".equals(mean))
            query.addCriteria(Criteria.where("mean").regex(mean));

        return mongoTemplate.find(query, Word.class);
    }

    @Override
    public Word addWord(WordParamV1 wordParamV1) {
        Word word = new Word();
        word.setLangCode(wordParamV1.getLangCode());
        word.setWord(wordParamV1.getWord());

        List means = new ArrayList<Mean>();
        for (MeanParamV1 meanParamV1: wordParamV1.getMeans()) {
            Mean mean = new Mean();
            mean.setPart(meanParamV1.getPart());
            mean.setMean(meanParamV1.getMean());

            List wordExamples = new ArrayList<WordExample>();
            for (WordExampleParamV1 wordExampleParamV1 : meanParamV1.getWordExamples()) {
                WordExample example = new WordExample();
                example.setSentence(wordExampleParamV1.getSentence());
                example.setTranslate(wordExampleParamV1.getTranslate());
                wordExamples.add(example);
            }
            mean.setWordExamples(wordExamples);
            means.add(mean);
        }
        word.setMeans(means);

        wordMongodbRepository.save(word);

        return word;
    }
}
