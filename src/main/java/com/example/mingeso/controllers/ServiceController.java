package com.example.mingeso.controllers;

import com.example.mingeso.models.Service;
import com.example.mingeso.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RequestMapping("/services")
public class ServiceController {
    @Autowired

    private ServiceRepository serviceRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Service> getAllService() {
        List<Service> all = serviceRepository.findAll();
        return all;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Service one(@PathVariable("id") String id) {
        Service service = serviceRepository.findByid(id);
        return service;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Service updateService(@PathVariable String id, @RequestBody Service service) {
        if (!service.getId().equals(id)) {
            return null;
        }
        return this.serviceRepository.save(service);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Service create(@Valid @RequestBody Service service) {
        serviceRepository.save(service);
        return service;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @CrossOrigin
    public void delete(@PathVariable String id) {
        serviceRepository.delete(serviceRepository.findByid(id));
    }
}



