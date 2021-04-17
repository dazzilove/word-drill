package com.dazzilove.app.worddrill.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class QuizSheet {
    @Id
    private String id;
    private String langCode;
    private String title;
    private List<Word> words;
}
