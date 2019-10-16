package com.example.mingeso;
import com.example.mingeso.models.*;
import com.example.mingeso.repositories.*;
import com.example.mingeso.controllers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MingesoApplicationTests {
private    RoomRepository roomRepository;
private EntityManager entityManager ;
private String nueva="nueva";


    @Test
    public void RoomGettersSettersTest() throws ParseException {
       Room room = new Room();
        room.setNumber("23");
        room.setFloor("2");
        room.setDescription(nueva);
        room.setPrice("25000");
        room.setClientList(null);
        room.setOccupied(true);
   assertEquals(room.getNumber(),"23");
   assertEquals(room.getClientList(),null);
   assertEquals(room.getFloor(),"2");
   assertEquals(room.getDescription(),nueva);
   assertEquals(room.getPrice(),"25000");


    }


    @Test
    public void BookingGettersSettersTest() throws ParseException {
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
    public void BoxGettersSettersTest()throws ParseException {
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
    public void ClientGettersSettersTest()throws ParseException {
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
    @Test
    public void ServiceGettersSettersTest()throws ParseException {
       Service service = new Service();
        service.setName("Tenis");
        service.setDescription("Nuevo servicio");
        service.setPrice("20000");
        service.setCategory("deporte");
        
   assertEquals(service.getName(),"Tenis");
   assertEquals(service.getDescription(),"Nuevo servicio");
   assertEquals(service.getPrice(),"20000");
   assertEquals(service.getCategory(),"deporte");


    }
        @Test
    public void UserGettersSettersTest() throws ParseException{
       User user = new User();
        user.setUsername("Matiti");
        user.setPassword("123");
        user.setAdmin(true);
        
   assertEquals(user.getUsername(),"Matiti");
   assertEquals(user.getPassword(),"123");
   assertEquals(user.getAdmin(),    true);



    }



            @Test
    public void VoucherGettersSettersTest() throws ParseException{
       Voucher voucher = new Voucher();
        voucher.setPrice("200000");
        voucher.setStartDate("10/10/2019");
        voucher.setEndDate("11/10/2019");
        voucher.setPaidOut(true);
        voucher.setServices(null);
        voucher.setBoxUsed(null);
        voucher.setRoomUsed(null);
   assertEquals(voucher.getPrice(),"200000");
   assertEquals(voucher.getStartDate(),"10/10/2019");
   assertEquals(voucher.getEndDate(),"11/10/2019");
   assertEquals(voucher.getPaidOut(),true);
   assertEquals(voucher.getServices(),null);
   assertEquals(voucher.getBoxUsed(),null);
   assertEquals(voucher.getRoomUsed(),null);


    }
    @Test
    public void RoomConstructorTest() throws ParseException{
       Room room = new Room("23","2",nueva,"25000",null);
   assertEquals(room.getNumber(),"23");
   assertEquals(room.getClientList(),null);
   assertEquals(room.getFloor(),"2");
   assertEquals(room.getDescription(),nueva);
   assertEquals(room.getPrice(),"25000");


    }


    @Test
    public void BookingConstructorTest()throws ParseException {
        Room room =new Room();

       Booking booking = new Booking("matias", "10/12/2019","11/12/2019",room);
        
   assertEquals(booking.getOwner(),"matias");
   assertEquals(booking.getStartDate(),"10/12/2019");
   assertEquals(booking.getEndDate(),"11/12/2019");
   assertEquals(booking.getRoom(),room);


    }

@Test
    public void BoxConstructorTest() throws ParseException{
       Box box = new Box("Package2", "nuevo paquete", "20000", null);
   assertEquals(box.getName(),"Package2");
   assertEquals(box.getDescription(),"nuevo paquete");
   assertEquals(box.getPrice(),"20000");
   assertEquals(box.getServiceList(),null);


    }

    @Test
    public void ClientConstructorTest()throws ParseException {
       Client client = new Client("Matias","Pizarro","2","direccion","19700195k","matias.piarro@usach.cl","20192319" );
   assertEquals(client.getName(),"Matias");
   assertEquals(client.getLastName(),"Pizarro");
   assertEquals(client.getAge(),"2");
   assertEquals(client.getAddress(),"direccion");
 assertEquals(client.getRoomOwner(),false);
 assertEquals(client.getMail(),"matias.piarro@usach.cl");
 assertEquals(client.getRut(),"19700195k");
 assertEquals(client.getPhone(),"20192319");


    }
    @Test
    public void ServiceConstructorTest() throws ParseException{
       Service service = new Service("Tenis","deporte", "20000","Nuevo servicio");
        service.setName("Tenis");
        service.setDescription("Nuevo servicio");
        service.setPrice("20000");
        service.setCategory("deporte");
        
   assertEquals(service.getName(),"Tenis");
   assertEquals(service.getDescription(),"Nuevo servicio");
   assertEquals(service.getPrice(),"20000");
   assertEquals(service.getCategory(),"deporte");


    }
        @Test
    public void UserConstructorTest() throws ParseException{
       User user = new User("Matiti","123");  
   assertEquals(user.getUsername(),"Matiti");
   assertEquals(user.getPassword(),"123");
   assertEquals(user.getAdmin(),false);



    }



            @Test
    public void VoucherConstructorTest() throws ParseException{
                Voucher voucher = new Voucher("200000", null, null, null, "20", "23");
                assertEquals(voucher.getPrice(), "200000");
                assertEquals(voucher.getPaidOut(), true);
                assertEquals(voucher.getServices(), null);
                assertEquals(voucher.getBoxUsed(), null);
                assertEquals(voucher.getRoomUsed(), null);


            }

}
