package com.dazzilove.worddrill.app.controller.dto;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class WordParamV1 {
    private String langCode;
    private String word;
    private ArrayList<MeanParamV1> means;
}
