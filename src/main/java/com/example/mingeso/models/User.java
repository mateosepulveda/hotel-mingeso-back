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
    private String mail;
    private String password;
    private Boolean admin;


    public User(String username, String password, String mail){
        this.username=username;
        this.password=password;
        this.mail=mail;
        this.admin= false;
    }
    public String getId() {
        return this.id;
    }

    public String getMail(){
        return this.mail;
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
    public void setMail(String mail){
        this.mail=mail;
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
