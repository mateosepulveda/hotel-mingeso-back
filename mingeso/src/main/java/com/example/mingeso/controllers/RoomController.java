package com.example.mingeso.controllers;

import com.example.mingeso.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Room;
import com.example.mingeso.repositories.RoomRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Room createRoom(@Valid @RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }

/*    @CrossOrigin
    @RequestMapping("/createRoom")
    public String create(@RequestParam String number, @RequestParam String floor, @RequestParam String description, @RequestParam String price) {
        Room r = roomRepository.save(new Room(number, floor, description, price));
        return r.toString();
    }*/

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Room getRoomById(@PathVariable("id") String id) {
        return roomRepository.findByid(id);
    }

    @RequestMapping(value = "/getByNumber/{number}", method = RequestMethod.GET)
    public Room getRoomByNumber(@PathVariable("number") String number) {
        return roomRepository.findByNumber(number);
    }

    @RequestMapping(value = "/getByFloor/{floor}", method = RequestMethod.GET)
    public List<Room> getRoomByFloor(@PathVariable("floor") String floor) {
        return roomRepository.findByFloor(floor);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Room updateRoomById(@PathVariable String id, @RequestBody Room room) {
        if (!room.getId().equals(id)) {
            return null;
        }
        return roomRepository.save(room);
    }

/*    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public Room updateRoomById(@PathVariable("id") String id, @RequestParam String number, @RequestParam String description, @RequestParam String price) {
        Room r = roomRepository.findByid(id);
        r.setDescription(description);
        r.setPrice(price);
        return roomRepository.save(r);
    }*/

    @RequestMapping(value = "/updateByNumber/{number}", method = RequestMethod.PUT)
    @ResponseBody
    public Room updateRoomByNumber(@PathVariable String number, @RequestBody Room room) {
        if (!room.getNumber().equals(number)) {
            return null;
        }
        return roomRepository.save(room);
    }

/*    @RequestMapping(value = "/updateByNumber/{number}", method = RequestMethod.PUT)
    public Room updateRoomByNumber(@PathVariable("number") String number, @RequestParam String description, @RequestParam String price) {
        Room r = roomRepository.findByNumber(number);
        r.setDescription(description);
        r.setPrice(price);
        return roomRepository.save(r);
    }*/

    @CrossOrigin
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteRoomById(@PathVariable("id") String id) {
        Room r = roomRepository.findByid(id);
        roomRepository.delete(r);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteByNumber/{number}", method = RequestMethod.DELETE)
    public void deleteRoomByNumber(@PathVariable("number") String number) {
        Room r = roomRepository.findByNumber(number);
        roomRepository.delete(r);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }
}
