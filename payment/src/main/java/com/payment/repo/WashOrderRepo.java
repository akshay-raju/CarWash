package com.payment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.payment.model.WashOrder;

public interface WashOrderRepo extends MongoRepository<WashOrder, String>{

}
