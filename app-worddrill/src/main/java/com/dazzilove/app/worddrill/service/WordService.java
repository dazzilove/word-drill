package com.dazzilove.app.worddrill.service;

import com.dazzilove.app.worddrill.controller.dto.WordParamV1;
import com.dazzilove.app.worddrill.controller.dto.WordSearchParamV1;
import com.dazzilove.app.worddrill.domain.Word;

import java.util.List;

public interface WordService {
    Word addWord(WordParamV1 wordParamV1);
    List<Word> getList(WordSearchParamV1 wordSearchParamV1);
}
