package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.mingeso.models.Booking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.mingeso.models.Client;
@RunWith(SpringRunner.class)

@SpringBootTest
public class TestBookingController extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test

    public void getBookingList() throws Exception {
        String uri = "/bookings/getAll";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Booking[] bookingList = super.mapFromJson(content, Booking[].class);
        assertTrue(bookingList.length > 0);
    }

    @Test
    public void createBooking() throws Exception {
        String uri = "/bookings/create";
        Booking booking = new Booking("Test", "10/10/2019", "11/10/2019", null);
        String inputJson = super.mapToJson(booking);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

}

