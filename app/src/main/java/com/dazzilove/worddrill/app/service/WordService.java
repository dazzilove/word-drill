package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.domain.Word;

import java.util.List;

public interface WordService {
    Word addWord(WordParamV1 wordParamV1);

    List<Word> getList();
}
