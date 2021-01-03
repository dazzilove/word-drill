package com.dazzilove.worddrill.app.controller;

import com.dazzilove.worddrill.app.controller.dto.WordParamV1;
import com.dazzilove.worddrill.app.domain.Word;
import com.dazzilove.worddrill.app.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @Autowired
    private WordService wordService;

    @PostMapping("/api/word")
    public String addWord(@RequestBody WordParamV1 wordParamV1) {
        Word word = wordService.addWord(wordParamV1);
        return word.toString();
    }
}
