package com.example.mingeso.repositories;

import com.example.mingeso.models.Box;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mingeso.models.Box;

@Repository
public interface BoxRepository extends MongoRepository<Box, String> {
    Box findByName(String name);
    Box findByid(String id);
}
