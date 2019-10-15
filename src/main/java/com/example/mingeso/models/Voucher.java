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

       public String getId() {
        return this.id;
    }

    public String getPrice() {
        return this.price;
p   }

    public List<Service> getServices() {
        return this.services;
    }

    public Box getBoxUsed() {
        return this.boxUsed;
    }

    public Client getOwner() {
        return this.owner;
    }
        public Room getRoomUsed() {
        return this.roomUsed;
    }
    
   
      
      

    public void setPrice(String price) {
         this.price=price;
        return
}

    public void setServices() {
        this.services;
    return 
    }

    public void setBoxUsed() {
        return this.boxUsed;
    }

    public void setOwner() {
        return this.owner;
    }
        public void setRoomUsed() {
        return this.roomUsed;
    }
    
}
