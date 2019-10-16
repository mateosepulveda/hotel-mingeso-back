package com.example.mingeso.models;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
@Getter @Setter
@Data
@NoArgsConstructor
public class Room {
    @Id
    private String id;
    private String number;
    private String floor;
    private String description;
    private List<Client> clientList;
    private String price;
    //private byte capacity;
    private boolean occupied;

    public Room(String number, String floor, String description, String price, List<Client> clientList) {
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

    public String getNumber() {
        return this.number;
    }
    public List<Client> getClientList() {
        return this.clientList;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
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