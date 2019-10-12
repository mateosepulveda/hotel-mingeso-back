package com.example.mingeso.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mingeso.models.Booking;
import java.util.List;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
    Booking findByid(String id);
    List<Booking> findByOwner(String owner);
    List<Booking> findByRoomNumber(String roomNumber);
}
