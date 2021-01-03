package com.dazzilove.worddrill.app.domain.repository.mongodb;

import com.dazzilove.worddrill.app.domain.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface WordMongodbRepository extends MongoRepository<Word, String> {
}
