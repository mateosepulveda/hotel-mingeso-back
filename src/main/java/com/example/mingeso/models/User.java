package com.example.mingeso.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
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
    public String getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Boolean getAdmin() {
        return this.admin;
    }


    public void setUsername(String username) {
        this.username=username;
        return;
    }

    public void setPassword(String password) {
        this.password=password ;
        return;
    }

    public void setAdmin(Boolean admin) {
        this.admin=admin;
        return;
    }


}
