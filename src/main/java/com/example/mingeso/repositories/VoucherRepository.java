package com.example.mingeso.repositories;


import com.example.mingeso.models.Voucher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoucherRepository extends CrudRepository<Voucher, String> {
    Voucher findByid(String id);

    @Override
    List<Voucher> findAll();}

