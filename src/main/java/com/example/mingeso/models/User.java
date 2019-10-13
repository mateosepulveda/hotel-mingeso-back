package com.example.mingeso.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
@Data
@Getter
@Setter
@Document(collection = "users")

public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean admin;


    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.admin= false;
    }

}
