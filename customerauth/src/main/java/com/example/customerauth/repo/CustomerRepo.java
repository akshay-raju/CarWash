package com.example.customerauth.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.customerauth.pojo.Customer;
@Repository
public interface CustomerRepo extends MongoRepository<Customer, String> {

}
