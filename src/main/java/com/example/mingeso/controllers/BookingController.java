package com.example.mingeso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.mingeso.models.Booking;
import com.example.mingeso.repositories.BookingRepository;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @CrossOrigin
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        bookingRepository.save(booking);
        return booking;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Booking getBookingById(@PathVariable("id") String id) {
        return bookingRepository.findByid(id);
    }

    @RequestMapping(value = "/getByOwner/{owner}", method = RequestMethod.GET)
    public List<Booking> getBookingByOwner(@PathVariable("owner") String owner) {
        return bookingRepository.findByOwner(owner);
    }

    /*
    @RequestMapping(value = "/getByRoomNumber/{roomNumber}", method = RequestMethod.GET)
    public List<Booking> getBookingByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        return bookingRepository.findByRoomNumber(roomNumber);
    }
    */

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

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
        Booking b = bookingRepository.findByid(id);
        bookingRepository.delete(b);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteByOwner/{owner}", method = RequestMethod.DELETE)
    public void deleteBookingByOwner(@PathVariable("owner") String owner) {
        List<Booking> listBookings = bookingRepository.findByOwner(owner);
        for (int i = 0; i < listBookings.size(); i++) {
            bookingRepository.delete(listBookings.get(i));
        }
    }

    /*
    @CrossOrigin
    @RequestMapping(value = "/deleteByRoomNumber/{roomNumber}", method = RequestMethod.DELETE)
    public void deleteBookingByRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        List<Booking> listBookings = bookingRepository.findByRoomNumber(roomNumber);
        for (int i = 0; i < listBookings.size(); i++) {
            bookingRepository.delete(listBookings.get(i));
        }
    }
    */

    @CrossOrigin
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAllBookings() {
        bookingRepository.deleteAll();
    }
}
