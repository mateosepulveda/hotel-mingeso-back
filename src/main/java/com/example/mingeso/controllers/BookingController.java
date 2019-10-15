package com.example.mingeso.controllers;

import com.sun.org.apache.xpath.internal.objects.XObject;
import org.openqa.selenium.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Booking;
import com.example.mingeso.repositories.BookingRepository;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createBooking(@Valid @RequestBody List<Booking> bookings) {
        for(Booking booking:bookings)
        {
            System.out.println(booking);
            bookingRepository.save(booking);
        }
        return;
    }

    @CrossOrigin
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Booking getBookingById(@PathVariable("id") String id) {
        return bookingRepository.findByid(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<Booking> getBookingByOwner(@PathVariable("owner") String owner) {
        return bookingRepository.findByOwner(owner);
    }



    @CrossOrigin
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Booking updateRoomById(@PathVariable String id, @RequestBody Booking booking) {
        if (!booking.getId().equals(id)) {
            return null;
        }
        return bookingRepository.save(booking);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteBookingById(@PathVariable("id") String id) {
            System.out.println("ENTRssssA");
            bookingRepository.delete(bookingRepository.findByid(id));
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteByOwner/{owner}", method = RequestMethod.DELETE)
    public void deleteBookingByOwner(@PathVariable("owner") String owner) {
        System.out.println("ENTRssssA222");
        List<Booking> listBookings = bookingRepository.findByOwner(owner);
        for (int i = 0; i < listBookings.size(); i++) {
            bookingRepository.delete(listBookings.get(i));
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllBookings() {
        bookingRepository.deleteAll();
    }
}
