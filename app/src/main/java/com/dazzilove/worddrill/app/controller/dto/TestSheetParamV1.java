package com.dazzilove.worddrill.app.controller.dto;

import com.dazzilove.worddrill.app.domain.Word;
import lombok.Data;

import java.util.List;

@Data
public class TestSheetParamV1 {
    private String id;
    private String langCode;
    private String title;
    private List<Word> words;
}
