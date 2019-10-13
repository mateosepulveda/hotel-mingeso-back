package com.example.mingeso.controllers;

import com.example.mingeso.models.User;
import com.example.mingeso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class UserController {
    @Autowired

    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User one(@PathVariable("id") String id) {
        User user = userRepository.findByid(id);
        return user;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        if (!user.getId().equals(id)) {
            return null;
        }
        return this.userRepository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public User create(@Valid @RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @CrossOrigin
    public void delete(@PathVariable String id) {
        userRepository.delete(userRepository.findByid(id));
    }
}



