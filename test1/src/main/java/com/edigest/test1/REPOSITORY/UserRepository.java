package com.edigest.test1.REPOSITORY;

import com.edigest.test1.Entity.JournalEntry;
import com.edigest.test1.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface
UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName( String username);

    void deleteByUserName(String username);

}
