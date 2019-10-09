package com.example.mingeso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.mingeso.models.Room;
import com.example.mingeso.repositories.RoomRepository;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping("/create")
    public String create(@RequestParam String number, @RequestParam String floor, @RequestParam String description, @RequestParam String price) {
        Room r = roomRepository.save(new Room(number, floor, description, price));
        return r.toString();
    }

    @RequestMapping("/getByNumber")
    public Room getRoomByNumber(@RequestParam String number) {
        return roomRepository.findByNumber(number);
    }

    @RequestMapping("/getByFloor")
    public List<Room> getRoomByFloor(@RequestParam String floor) {
        return roomRepository.findByFloor(floor);
    }

    @RequestMapping("/getAll")
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @RequestMapping("/update")
    public Room update(@RequestParam String number, @RequestParam String description, @RequestParam String price) {
        Room r = roomRepository.findByNumber(number);
        r.setDescription(description);
        r.setPrice(price);
        return roomRepository.save(r);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam String number) {
        Room r = roomRepository.findByNumber(number);
        roomRepository.delete(r);
    }

    @RequestMapping("/deleteAll")
    public void deleteAll() {
        roomRepository.deleteAll();
    }
}
