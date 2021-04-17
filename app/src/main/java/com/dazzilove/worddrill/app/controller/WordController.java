package com.dazzilove.worddrill.app.controller;

import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.controller.dto.WordSearchParamV1;
import com.dazzilove.worddrill.app.domain.Word;
import com.dazzilove.worddrill.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/api/word/list")
    public List<Word> getWord(@Param(value = "langCode") String langCode,
                              @Param(value = "word") String word,
                              @Param(value = "mean") String mean) {
        WordSearchParamV1 wordSearchParamV1 = new WordSearchParamV1();
        wordSearchParamV1.setLangCode(langCode);
        wordSearchParamV1.setWord(word);
        wordSearchParamV1.setMean(mean);

        return wordService.getList(wordSearchParamV1);
    }   

    @PostMapping("/api/word")
    public Word addWord(@RequestBody WordParamV1 wordParamV1) {
        return wordService.addWord(wordParamV1);
    }
}
