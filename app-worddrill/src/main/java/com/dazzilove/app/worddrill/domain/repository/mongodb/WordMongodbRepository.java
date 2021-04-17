package com.dazzilove.app.worddrill.domain.repository.mongodb;

import com.dazzilove.app.worddrill.domain.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface WordMongodbRepository extends MongoRepository<Word, String> {
}
