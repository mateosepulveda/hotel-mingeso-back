package com.example.mingeso.models;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
@NoArgsConstructor
public class Room {
    @Id
    private String id;
    private short number;
    private short floor;
    private String description;
    private List<Client> clientList;
    private Integer price;
    //private byte capacity;
    private boolean occupied;

    public Room(short number, short floor, String description, Integer price, List<Client> clientList) {
        this.number = number;
        this.floor = floor;
        this.description = description;
        this.clientList = clientList;
        this.price = price;
        this.occupied = true;
    }

    public String getId() {
        return this.id;
    }

    public short getNumber() {
        return this.number;
    }
public List<Client> getClientList() {
        return this.clientList;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
public void setClientList(List<Client> clientsList ) {
        this.clientList = clientList;
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