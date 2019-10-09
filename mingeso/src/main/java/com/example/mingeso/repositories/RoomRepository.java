package com.example.mingeso.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mingeso.models.Room;
import java.util.List;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    public Room findByNumber(String number);
    public List<Room> findByFloor(String floor);
}
