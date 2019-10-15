package com.example.mingeso.models;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static java.sql.JDBCType.NULL;

@Data
@Getter
@Setter
@Document(collection = "vouchers")
public class Voucher {
    @Id
    private String id;
    private String price;
    private String startDate;
    private String endDate;
    private List<Service> services;
    private Box boxUsed;
    private Room roomUsed;
    private Boolean paidOut;

    public Voucher (String price, List<Service> services, Box boxUsed, Room roomUsed,Client owner ){
        this.price=price;
        this.services=services;
        this.boxUsed=boxUsed;
        this.roomUsed=roomUsed;
        this.paidOut=true;
    }

       public String getId() {
        return this.id;
    }

    public String getPrice() {
        return this.price;
  }

    public List<Service> getServices() {
        return this.services;
    }

    public Box getBoxUsed() {
        return this.boxUsed;
    }

        public Room getRoomUsed() {
        return this.roomUsed;
    }




    public String getStartDate() {
        return this.startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }
    public void setPrice(String price) {
         this.price=price;
        return;
}

    public void setServices(List<Service> services) {
        this.services=services;
    return ;
    }

    public void setBoxUsed(Box boxUsed) {

         this.boxUsed=boxUsed;
        return;
    }


    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

        public void setRoomUsed(Room roomUsed) {
        this.roomUsed= roomUsed;

        return ;
    }
    
}
