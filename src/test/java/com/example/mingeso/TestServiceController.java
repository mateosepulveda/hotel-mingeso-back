package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceController extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

  /*  @Test
    public void getServiceList() throws Exception {
        String uri = "/services/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Service[] serviceList = super.mapFromJson(content, Service[].class);
        assertTrue(serviceList.length > 0);
    }
*/
    @Test
    public void createService() throws Exception {
        String uri = "/services/";
        Service service = new Service("Tenis", "deporte", "2000", "descripcion");
        String inputJson = super.mapToJson(service);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
}