package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.domain.Word;

public interface WordService {
    Word addWord(WordParamV1 wordParamV1);
}
