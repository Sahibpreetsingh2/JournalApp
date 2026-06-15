package com.edigest.test1.REPOSITORY;

import com.edigest.test1.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSA(){
        Query query = new Query();

//        query.addCriteria(Criteria.where("age").gte(20));
//        Criteria criteria = new Criteria();
//        query.addCriteria(criteria.orOperator(
//               Criteria.where("email").exists(true),
//                Criteria.where("sentimentAnalysis").is(true))
//        );

        query.addCriteria(
                Criteria.where("email").regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"));
              query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

        
        return   mongoTemplate.find(query, User.class);

    }
}
