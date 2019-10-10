package com.example.mingeso.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mingeso.models.Package;

@Repository
public interface PackageRepository extends MongoRepository<Package, String> {
    Package findByName(String name);
    Package findByid(String id);
}
