package com.dazzilove.worddrill.app.service;

import com.dazzilove.worddrill.app.controller.dto.TestSheetParamV1;
import com.dazzilove.worddrill.app.domain.TestSheet;

import java.util.List;

public interface TestSheetService {
    TestSheet findById(String id);
    TestSheet addTestSheet(TestSheetParamV1 testSheetParamV1);
    List<TestSheet> getList();
}
