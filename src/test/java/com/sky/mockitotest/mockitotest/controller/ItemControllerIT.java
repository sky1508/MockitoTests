package com.sky.mockitotest.mockitotest.controller;

import com.sky.mockitotest.mockitotest.data.ItemRepository;
import com.sky.mockitotest.mockitotest.spike.JsonAssertTest;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() throws JSONException {

        String response = this.testRestTemplate.getForObject("/all-item-from-database", String.class);

        JSONAssert.assertEquals("[{id:1},{id:2},{id:3}]",response,false);
    }
}
