package com.example.mingeso;
import com.example.mingeso.models.*;
import com.example.mingeso.repositories.*;
import com.example.mingeso.controllers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MingesoApplicationTests {
private    RoomRepository roomRepository;
private EntityManager entityManager ;


    @Test
    public void RoomGettersSettersTest() {
       Room room = new Room();
        Byte capacity = 2;
        room.setNumber("23");
        room.setFloor("2");
        room.setDescription("nueva");
        room.setPrice("25000");
        room.setClientList(null);
        room.setOccupied(true);
   assertEquals(room.getNumber(),"23");
   assertEquals(room.getClientList(),null);
   assertEquals(room.getFloor(),"2");
   assertEquals(room.getDescription(),"nueva");
   assertEquals(room.getPrice(),"25000");


    }


    @Test
    public void BookingGettersSettersTest() {
       Booking booking = new Booking();
        Room room =new Room();
        booking.setOwner("matias");
        booking.setStartDate("10/12/2019");
        booking.setEndDate("11/12/2019");
        booking.setRoom(room);
        
   assertEquals(booking.getOwner(),"matias");
   assertEquals(booking.getStartDate(),"10/12/2019");
   assertEquals(booking.getEndDate(),"11/12/2019");
   assertEquals(booking.getRoom(),room);


    }

@Test
    public void BoxGettersSettersTest() {
       Box box = new Box();
        box.setName("Package2");
        box.setDescription("Nuevo paquete");
        box.setPrice("20000");
        box.setServiceList(null);
        
   assertEquals(box.getName(),"Package2");
   assertEquals(box.getDescription(),"Nuevo paquete");
   assertEquals(box.getPrice(),"20000");
   assertEquals(box.getServiceList(),null);


    }

    @Test
    public void ClientGettersSettersTest() {
       Client client = new Client();
        client.setName("Matias");
        client.setLastName("Pizarro");
        client.setAge("2");
        client.setRoomOwner(true);
        client.setMail("matias.piarro@usach.cl");
        client.setRut("19700195k");
        client.setPhone("20192319");
        client.setAddress("direccion");
        
   assertEquals(client.getName(),"Matias");
   assertEquals(client.getLastName(),"Pizarro");
   assertEquals(client.getAge(),"2");
   assertEquals(client.getAddress(),"direccion");
 assertEquals(client.getRoomOwner(),true);
 assertEquals(client.getMail(),"matias.piarro@usach.cl");
 assertEquals(client.getRut(),"19700195k");
 assertEquals(client.getPhone(),"20192319");


    }



}
