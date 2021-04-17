package com.dazzilove.app.worddrill.controller;

import com.dazzilove.app.worddrill.controller.dto.QuizSheetParamV1;
import com.dazzilove.app.worddrill.domain.QuizSheet;
import com.dazzilove.app.worddrill.service.QuizSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizSheetController {

    @Autowired
    private QuizSheetService quizSheetService;

    @GetMapping("/api/testSheet/list")
    public List<QuizSheet> getWord() {
        return quizSheetService.getList();
    }

    @GetMapping("/api/testSheet")
    public QuizSheet getTestSheet(@Param(value = "id") String id) {
        return quizSheetService.findById(id);
    }

    @PostMapping("/api/testSheet")
    public QuizSheet addTestSheet(@RequestBody QuizSheetParamV1 quizSheetParamV1) {
        return quizSheetService.addTestSheet(quizSheetParamV1);
    }
}
