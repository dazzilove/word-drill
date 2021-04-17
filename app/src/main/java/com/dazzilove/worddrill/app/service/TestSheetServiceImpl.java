package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.TestSheetParamV1;
import com.dazzilove.worddrill.app.domain.TestSheet;
import com.dazzilove.worddrill.app.domain.repository.mongodb.TestSheetMongodbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSheetServiceImpl implements TestSheetService {

    @Autowired
    private TestSheetMongodbRepository testSheetMongodbRepository;

    @Override
    public TestSheet findById(String id) {
        return testSheetMongodbRepository.findById(id).orElse(new TestSheet());
    }

    @Override
    public TestSheet addTestSheet(TestSheetParamV1 testSheetParamV1) {
        TestSheet testSheet = new TestSheet();
        testSheet.setLangCode(testSheetParamV1.getLangCode());
        testSheet.setTitle(testSheetParamV1.getTitle());
        testSheet.setWords(testSheetParamV1.getWords());
        return testSheetMongodbRepository.save(testSheet);
    }

    @Override
    public List<TestSheet> getList() {
        return testSheetMongodbRepository.findAll();
    }
}
