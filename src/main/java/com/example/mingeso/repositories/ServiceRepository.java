package com.example.mingeso.repositories;


import com.example.mingeso.models.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepository extends CrudRepository<Service, String> {
    Service findByid(String id);

    @Override
    List<Service> findAll();}
