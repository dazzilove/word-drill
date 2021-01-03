package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.ExampleParamV1;
import com.dazzilove.worddrill.app.controller.dto.MeanParamV1;
import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.domain.Example;
import com.dazzilove.worddrill.app.domain.Mean;
import com.dazzilove.worddrill.app.domain.Word;
import com.dazzilove.worddrill.app.domain.repository.mongodb.WordMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordMongodbRepository wordMongodbRepository;

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

            List examples = new ArrayList<Example>();
            for (ExampleParamV1 exampleParamV1: meanParamV1.getExamples()) {
                Example example = new Example();
                example.setSentence(exampleParamV1.getSentence());
                example.setTranslate(exampleParamV1.getTranslate());
                examples.add(example);
            }
            mean.setExamples(examples);
            means.add(mean);
        }
        word.setMeans(means);

        wordMongodbRepository.save(word);

        return word;
    }
}
