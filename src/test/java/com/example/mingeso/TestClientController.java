package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mingeso.models.Client;
@RunWith(SpringRunner.class)
@SpringBootTest
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
        Client[] clientList = super.mapFromJson(content, Client[].class);
        assertTrue(clientList.length > 0);
    }

    @Test
    public void createClient() throws Exception {
        String uri = "/clients/";
        Client client = new Client("Test","Test","21","Test","2019","Test@Test.cl","236768271");
        String inputJson = super.mapToJson   
        
           (client);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    /*@Test
    public void updateProduct() throws Exception {
        String uri = "/clients/5da260e49371d42cb7cfe260";
        Client client = new Client();
        client.setName("Lemon");
        String inputJson = super.mapToJson(client);
, status);
    }

    @Test
    public void deleteProduct() throws Exception {
        String uri = "/clients/5da260e39371d42cb7cfe25f";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);


    }*/
}