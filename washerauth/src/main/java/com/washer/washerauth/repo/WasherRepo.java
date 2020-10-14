package com.washer.washerauth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.washer.washerauth.pojo.Washer;
@Repository
public interface WasherRepo extends MongoRepository<Washer, String> {

}
