package com.dazzilove.worddrill.app.controller;

import com.dazzilove.worddrill.app.controller.dto.TestSheetParamV1;
import com.dazzilove.worddrill.app.domain.TestSheet;
import com.dazzilove.worddrill.app.service.TestSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestSheetController {

    @Autowired
    private TestSheetService testSheetService;

    @GetMapping("/api/testSheet/list")
    public List<TestSheet> getWord() {
        return testSheetService.getList();
    }

    @GetMapping("/api/testSheet")
    public TestSheet getTestSheet(@Param(value = "id") String id) {
        return testSheetService.findById(id);
    }

    @PostMapping("/api/testSheet")
    public TestSheet addTestSheet(@RequestBody TestSheetParamV1 testSheetParamV1) {
        return testSheetService.addTestSheet(testSheetParamV1);
    }
}
