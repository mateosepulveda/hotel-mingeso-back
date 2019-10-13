package com.example.mingeso.repositories;


import com.example.mingeso.models.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client, String> {
    Client findByid(String id);

    @Override
    List<Client> findAll();}
