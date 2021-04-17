package com.dazzilove.app.worddrill.domain;

import lombok.Data;

import java.util.List;

@Data
public class Mean {
    private String part;
    private String mean;
    private List<WordExample> wordExamples;
}
