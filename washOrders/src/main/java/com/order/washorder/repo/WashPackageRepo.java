package com.order.washorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.order.washorder.model.WashPackage;
@Repository
public interface WashPackageRepo extends MongoRepository<WashPackage, String>{

}
