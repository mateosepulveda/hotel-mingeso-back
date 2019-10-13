package com.example.mingeso.controllers;

import com.example.mingeso.models.Box;
import com.example.mingeso.repositories.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class BoxController {
    @Autowired

    private BoxRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Box> getAllClients() {
        List<Box> all = repository.findAll();
        return all;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Box one(@PathVariable("id") String id) {
        Box box = repository.findByid(id);
        return box;
    }


    @RequestMapping(value = "/{id}/2", method = RequestMethod.PUT)
    @ResponseBody
    public Box updateClient(@PathVariable String id, @RequestBody Box box) {
        if (!box.getId().equals(id)) {
            return null;
        }
        return this.repository.save(box);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Box create(@Valid @RequestBody Box box) {
        repository.save(box);
        return box;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @CrossOrigin
    public void delete(@PathVariable String id) {
        repository.delete(repository.findByid(id));
    }
}



