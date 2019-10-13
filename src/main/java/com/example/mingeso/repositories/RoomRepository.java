package com.example.mingeso.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mingeso.models.Room;
import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

   Room findByid(String id);

    @Override
    List<Room> findAll();
    Room findByNumber(String number);
    List<Room> findByFloor(String floor);
}
