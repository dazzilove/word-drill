package com.dazzilove.worddrill.app.controller.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class MeanParamV1 {
    private String part;
    private String mean;
    private ArrayList<ExampleParamV1> examples;
}
