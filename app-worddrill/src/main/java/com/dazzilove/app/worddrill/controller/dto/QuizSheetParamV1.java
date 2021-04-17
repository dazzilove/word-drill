package com.dazzilove.app.worddrill.controller.dto;

import com.dazzilove.app.worddrill.domain.Word;
import lombok.Data;

import java.util.List;

@Data
public class QuizSheetParamV1 {
    private String id;
    private String langCode;
    private String title;
    private List<Word> words;
}
