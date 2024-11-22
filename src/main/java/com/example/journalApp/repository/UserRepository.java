package com.example.journalApp.repository;

import com.example.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<User, ObjectId>{
    User findByusername(String name);

    void deleteByUsername(String name);
}
