package com.example.journalApp.repository;

import com.example.journalApp.entity.JournalAppConfigEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalAppConfigRepository extends MongoRepository<JournalAppConfigEntity, ObjectId> {

}
