package com.edigest.test1.REPOSITORY;

import com.edigest.test1.Entity.ConfigJournalAppEntity;
import com.edigest.test1.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {
}
