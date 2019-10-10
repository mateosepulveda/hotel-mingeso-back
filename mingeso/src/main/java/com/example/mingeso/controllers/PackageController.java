package com.example.mingeso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Package;
import com.example.mingeso.repositories.PackageRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageRepository packageRepository;

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Package createPackage(@Valid @RequestBody Package pack) {
        packageRepository.save(pack);
        return pack;
    }

/*    @CrossOrigin
    @RequestMapping("/createPackage")
    public String create(@RequestParam String name, @RequestParam String description, @RequestParam String price) {
        Package p = packageRepository.save(new Package(name, description, price));
        return p.toString();
    }*/

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

/*    @RequestMapping(value = "/updateById/{id}", method = RequestMethod.PUT)
    public Package updatePackageById(@PathVariable("id") String id, @RequestParam String name, @RequestParam String description, @RequestParam String price) {
        Package p = packageRepository.findByid(id);
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        return packageRepository.save(p);
    }*/

    @RequestMapping(value = "/updateByName/{name}", method = RequestMethod.PUT)
    @ResponseBody
    public Package updatePackageByName(@PathVariable String name, @RequestBody Package pack) {
        if (!pack.getName().equals(name)) {
            return null;
        }
        return packageRepository.save(pack);
    }

/*    @RequestMapping(value = "/updateByName/{name}", method = RequestMethod.PUT)
    public Package updatePackageByName(@PathVariable("name") String name, @RequestParam String description, @RequestParam String price) {
        Package p = packageRepository.findByName(name);
        p.setDescription(description);
        p.setPrice(price);
        return roomRepository.save(p);
    }*/

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
