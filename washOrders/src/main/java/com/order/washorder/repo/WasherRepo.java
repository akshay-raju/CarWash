package com.order.washorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.washorder.model.Washer;
@Repository
public interface WasherRepo extends MongoRepository<Washer, String>{

}
