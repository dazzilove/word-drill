package com.dazzilove.app.worddrill.service;

import com.dazzilove.app.worddrill.controller.dto.QuizSheetParamV1;
import com.dazzilove.app.worddrill.domain.QuizSheet;

import java.util.List;

public interface QuizSheetService {
    QuizSheet findById(String id);
    QuizSheet addTestSheet(QuizSheetParamV1 quizSheetParamV1);
    List<QuizSheet> getList();
}
