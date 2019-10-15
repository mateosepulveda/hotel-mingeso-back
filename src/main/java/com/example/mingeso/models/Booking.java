package com.example.mingeso.models;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
@Getter
@Setter
public class Booking {
    @Id
    private String id;
    private String owner;
    private String startDate;
    private String endDate;
    private Room room;

    public Booking(String owner, String startDate, String endDate, Room room) {
        this.owner = owner;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

    public String getId() {
        return this.id;
    }

    public String getOwner() {
        return this.owner;
    }

    public Room getRoom() {
        return this.room;
    }

    public String getStartDate() {
        return this.startDate;
    }


    public String getEndDate() {
        return this.endDate;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
