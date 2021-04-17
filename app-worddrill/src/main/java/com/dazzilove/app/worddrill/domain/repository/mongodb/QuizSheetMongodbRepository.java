package com.dazzilove.app.worddrill.domain.repository.mongodb;

import com.dazzilove.app.worddrill.domain.QuizSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface QuizSheetMongodbRepository extends MongoRepository<QuizSheet, String> {
}
