package com.example.mingeso.controllers;

import com.example.mingeso.models.Voucher;
import com.example.mingeso.repositories.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class VoucherController {
    @Autowired

    private VoucherRepository voucherRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Voucher> getAllVoucher() {
        List<Voucher> all = voucherRepository.findAll();
        return all;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Voucher one(@PathVariable("id") String id) {
        Voucher voucher = voucherRepository.findByid(id);
        return voucher;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Voucher updateVoucher(@PathVariable String id, @RequestBody Voucher voucher) {
        if (!voucher.getId().equals(id)) {
            return null;
        }
        return this.voucherRepository.save(voucher);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin
    public Voucher create(@Valid @RequestBody Voucher voucher) {
        voucherRepository.save(voucher);
        return voucher;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @CrossOrigin
    public void delete(@PathVariable String id) {
        voucherRepository.delete(voucherRepository.findByid(id));
    }
}



