package com.example.mingeso;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.mingeso.models.User;
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
public class TestUserController extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /*@Test
    public void getUserList() throws Exception {
        String uri = "/users/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        User[] userList = super.mapFromJson(content, User[].class);
        assertTrue(userList.length > 0);
    }
*/
    @Test
    public void createUser() throws Exception {
        String uri = "/users/";
        User user = new User("javiera", "acevedo");
        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
    }
}