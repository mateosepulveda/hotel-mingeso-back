package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.mingeso.models.Box;
import com.example.mingeso.models.Service;
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

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBoxController extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

 /*   @Test
    public void getBoxList() throws Exception {
        String uri = "/boxes/";


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Box[] boxList = super.mapFromJson(content, Box[].class);
        assertTrue(boxList.length > 0);
    }
*/
    @Test
    public void createBox() throws Exception {
        String uri = "/boxes/";
        List<Service> services = null;
        Box box = new Box("Fultol-Tenis","Pelota-raqueta","2100",services);
        String inputJson = super.mapToJson(box);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
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