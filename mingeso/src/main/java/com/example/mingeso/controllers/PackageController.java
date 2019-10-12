package com.example.mingeso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Package;
import com.example.mingeso.repositories.PackageRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Package createPackage(@Valid @RequestBody Package pack) {
        packageRepository.save(pack);
        return pack;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Package getPackageById(@PathVariable("id") String id) {
        return packageRepository.findByid(id);
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public Package getPackageByName(@PathVariable("name") String name) {
        return packageRepository.findByName(name);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Package updatePackageById(@PathVariable String id, @RequestBody Package pack) {
        if (!pack.getId().equals(id)) {
            return null;
        }
        return packageRepository.save(pack);
    }

    @RequestMapping(value = "/updateByName/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public Package updatePackageByName(@PathVariable String name, @RequestBody Package pack) {
        if (!pack.getName().equals(name)) {
            return null;
        }
        return packageRepository.save(pack);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePackageById(@PathVariable("id") String id) {
        Package p = packageRepository.findByid(id);
        packageRepository.delete(p);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteByName/{name}", method = RequestMethod.DELETE)
    public void deletePackageByName(@PathVariable("name") String name) {
        Package p = packageRepository.findByName(name);
        packageRepository.delete(p);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllPackages() {
        packageRepository.deleteAll();
    }
}
