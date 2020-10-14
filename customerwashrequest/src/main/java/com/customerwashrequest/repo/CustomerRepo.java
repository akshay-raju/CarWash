package com.customerwashrequest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.customerwashrequest.pojo.Customer;

public interface CustomerRepo extends MongoRepository<Customer,String> {

}
