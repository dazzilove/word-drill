package com.dazzilove.app.worddrill.controller.dto;

import lombok.Data;

@Data
public class WordSearchParamV1 {
    private String langCode;
    private String word;
    private String mean;
}
