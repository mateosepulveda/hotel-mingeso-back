package com.example.mingeso.models;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
@Getter @Setter
public class Room {
    @Id
    private String id;
    private String number;
    private String floor;
    private String description;
    private List<Client> clientList;
    private String price;
    private boolean occupied;

    public Room(String number, String floor, String description, String price) {
        this.number = number;
        this.floor = floor;
        this.description = description;
        this.clientList = new ArrayList<Client>();
        this.price = price;
        this.occupied = false;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void emptyClientList() {
        this.clientList.clear();
        this.occupied = false;
    }

    public boolean clientListIsEmpty() {
        if (clientList.size() > 0) {
            return false;
        }
        return true;
    }
}