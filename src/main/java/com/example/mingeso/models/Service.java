package com.example.mingeso.models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.NoArgsConstructor;
@NoArgsConstructor
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
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setName(String name) {
        this.name=name;
        return;
    }

    public void setCategory(String category) {
        this.category=category ;
        return;
    }

    public void setPrice(String price) {
        this.price=price;
        return;
    }

    public void setDescription(String description) {
        this.description=description;
        return;

    }
}

