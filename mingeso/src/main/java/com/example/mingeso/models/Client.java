package com.example.mingeso.models;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
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
    private boolean roomOwner;
    private String rut;
    private String mail;
    private String phone;
    private List<Service> hiredServices= null ;
   // private List<Package> hiredPackages=null;
}
