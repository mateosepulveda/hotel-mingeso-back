package com.example.mingeso.models;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Getter
@Setter
@Document(collection = "vouchers")
public class Voucher {
    @Id
    private String id;
    private String price;
    private List<Service> services;
    private Box boxUsed;
    private Room roomUsed;
    private Client Owner ;
    private Boolean paidOut;

    public Voucher (String price, List<Service> services, Box boxUsed, Room roomUsed ){
        this.price=price;
        this.services=services;
        this.boxUsed=boxUsed;
        this.roomUsed=roomUsed;
        this.paidOut=true;
    }
}
