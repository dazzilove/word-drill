package com.dazzilove.worddrill.app.domain.repository.mongodb;

import com.dazzilove.worddrill.app.domain.TestSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface TestSheetMongodbRepository extends MongoRepository<TestSheet, String> {
}
