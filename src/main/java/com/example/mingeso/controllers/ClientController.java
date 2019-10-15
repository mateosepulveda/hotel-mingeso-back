package com.example.mingeso.controllers;
import com.example.mingeso.models.Client;
import com.example.mingeso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")

public class ClientController {
    @Autowired

    private ClientRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        List<Client> all = repository.findAll();
        return all;
    }

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public List<String> getAllNameClients() {
        List<Client> clients = repository.findAll();
        List<String> clientNames = new ArrayList();

        for (int i = 0; i < clients.size(); i++) {
            clientNames.add(clients.get(i).getName());
        }
        return clientNames;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Client one(@PathVariable("id") String id) {
        Client client = repository.findByid(id);
        return client;
    }


    @RequestMapping(value = "/{id}/2", method = RequestMethod.PUT)
    @ResponseBody
    public Client updateClient(@PathVariable String id, @RequestBody Client client) {
        if (!client.getId().equals(id)) {
            return null;
        }
        return this.repository.save(client);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Client create(@Valid @RequestBody Client client) {
        repository.save(client);
        return client;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @CrossOrigin
    public void delete(@PathVariable String id) {
        repository.delete(repository.findByid(id));
    }
}

