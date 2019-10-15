package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mingeso.models.Client;

public class TestClientController extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getClientList() throws Exception {
        String uri = "/clients/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Client [] clientList = super.mapFromJson(content, Client[].class);
        assertTrue(clientList.length > 0);
    }

}