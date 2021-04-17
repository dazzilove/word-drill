package com.dazzilove.app.worddrill.controller.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MeanParamV1 {
    private String part;
    private String mean;
    private ArrayList<WordExampleParamV1> wordExamples;
}
