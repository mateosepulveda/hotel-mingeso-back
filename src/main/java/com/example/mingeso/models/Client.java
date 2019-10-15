package com.example.mingeso.models;
import com.github.javafaker.Bool;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
//import javax.persistence.*;
import java.util.List;

@Data
@Document(collection = "clients")
public class Client {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String age;
    private String address;
    private Boolean roomOwner;
    private String rut;
    private String mail;
    private String phone;
   // private List<Service> hiredServices= null ;
   //private List<Package> hiredPackages=null;
   public Client (String name, String lastName, String age, String address, String rut, String mail, String phone ){
       this.name=name;
       this.lastName=lastName;
       this.age=age;
       this.address=address;
       this.rut=rut;
       this.mail=mail;
       this.phone=phone;

   }
    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public String getRut() {
        return this.rut;
    }
    public String getMail() {
        return this.mail;
    }
    public Boolean getRoomOwner() {
        return this.roomOwner;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setLastName(String lastName) {
        this.lastName=lastName;
       return;
    }

    public void setAge(String age) {
       this.age=age ;
       return;
    }

    public void setAddress(String address) {
       this.address=address;
       return;
    }

    public void setRut(String rut) {
       this.rut=rut;
       return;
    }
    public void setMail(String mail) {
       this.mail=mail;
       return;
    }
    public void setPhone(String phone)
    {
    this.phone=phone;
        return;
    }

    public void setRoomOwner(Boolean roomOwner)
    {
    this.roomOwner= roomOwner;
        return;
    }
}


