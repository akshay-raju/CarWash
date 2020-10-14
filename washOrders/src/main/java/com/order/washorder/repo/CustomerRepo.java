package com.order.washorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.washorder.model.Customer;
@Repository
public interface CustomerRepo extends MongoRepository<Customer, String>{

}
