package com.example.mingeso.controllers;

import com.example.mingeso.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Room;
import com.example.mingeso.repositories.RoomRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/rooms")
@CrossOrigin(origins = "*")

public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Room> getAllRoom() {
        List<Room> all = roomRepository.findAll();
        return all;
    }


    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Room one(@PathVariable("id") String id) {
        Room room = roomRepository.findByid(id);
        return room;
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Room updateRoom(@PathVariable String id, @RequestBody Room room) {
        if (!room.getId().equals(id)) {
            return null;
        }
        return this.roomRepository.save(room);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Room create(@Valid @RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Room getRoomById(@PathVariable("id") String id) {
        return roomRepository.findByid(id);
    }
        @ResponseStatus(value = HttpStatus.OK)
        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        @ResponseBody
        @CrossOrigin
    public void delete(@PathVariable String id) {
        roomRepository.delete(roomRepository.findByid(id));
    }







/*    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Room create(@Valid @RequestBody Room room) {
        roomRepository.save(room);
        return room;
    }
*/

    /*@RequestMapping("/getByNumber")
    public Room getRoomByNumber(@RequestParam String number) {
        return roomRepository.findByNumber(number);
    }

    @RequestMapping(value = "/getByFloor/{floor}", method = RequestMethod.GET)
    public List<Room> getRoomByFloor(@PathVariable("floor") String floor) {
        return roomRepository.findByFloor(floor);
    }
*/
/*
    @RequestMapping("/getAll")
    public List<Room> getAll() {
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

    @RequestMapping(value = "/updateByNumber/{number}", method = RequestMethod.PUT)
    @ResponseBody
    public Room updateRoomByNumber(@PathVariable String number, @RequestBody Room room) {
        if (!room.getNumber().equals(number)) {
            return null;
        }
        return roomRepository.save(room);
    }

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
*/

    @CrossOrigin
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllRooms() {
        roomRepository.deleteAll();
    }
}

