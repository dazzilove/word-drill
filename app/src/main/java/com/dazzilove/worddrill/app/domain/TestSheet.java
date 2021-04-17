package com.dazzilove.worddrill.app.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class TestSheet {
    @Id
    private String id;
    private String langCode;
    private String title;
    private List<Word> words;
}
