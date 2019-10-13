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

}


