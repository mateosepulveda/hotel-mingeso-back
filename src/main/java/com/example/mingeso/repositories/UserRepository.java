package com.example.mingeso.repositories;


import com.example.mingeso.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    User findByid(String id);

    @Override
    List<User> findAll();}
