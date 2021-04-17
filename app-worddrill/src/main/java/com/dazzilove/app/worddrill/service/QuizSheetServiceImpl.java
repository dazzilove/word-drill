package com.dazzilove.app.worddrill.service;

import com.dazzilove.app.worddrill.controller.dto.QuizSheetParamV1;
import com.dazzilove.app.worddrill.domain.QuizSheet;
import com.dazzilove.app.worddrill.domain.repository.mongodb.QuizSheetMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizSheetServiceImpl implements QuizSheetService {

    @Autowired
    private QuizSheetMongodbRepository quizSheetMongodbRepository;

    @Override
    public QuizSheet findById(String id) {
        return quizSheetMongodbRepository.findById(id).orElse(new QuizSheet());
    }

    @Override
    public QuizSheet addTestSheet(QuizSheetParamV1 quizSheetParamV1) {
        QuizSheet quizSheet = new QuizSheet();
        quizSheet.setLangCode(quizSheetParamV1.getLangCode());
        quizSheet.setTitle(quizSheetParamV1.getTitle());
        quizSheet.setWords(quizSheetParamV1.getWords());
        return quizSheetMongodbRepository.save(quizSheet);
    }

    @Override
    public List<QuizSheet> getList() {
        return quizSheetMongodbRepository.findAll();
    }
}
