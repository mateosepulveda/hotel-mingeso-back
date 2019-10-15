package com.example.mingeso.models;
import lombok.Setter;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "boxes")
@Getter @Setter
public class Box {
    @Id
    private String id;
    private String name;
    private String description;
    private String price;
    private List<Service> serviceList;

    public Box(String name, String description, String price, List<Service> serviceList) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.serviceList=serviceList;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
public List<Service> getServiceList() {
        return this.serviceList;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }
}
