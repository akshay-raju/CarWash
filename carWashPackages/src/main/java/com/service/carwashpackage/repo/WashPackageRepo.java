package com.service.carwashpackage.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.service.carwashpackage.model.WashPackage;
@Repository
public interface WashPackageRepo extends MongoRepository<WashPackage, String>{

}
