package com.example.mingeso.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Document(collection = "services")
public class Service {

    @Id
    private String id;
    private String name;
    private String category;
    private String price;
    private String description;

    public Service(String name, String category, String price, String description){
        this.name=name;
        this.category=category;
        this.price=price;
        this.description=description;

    }
}


