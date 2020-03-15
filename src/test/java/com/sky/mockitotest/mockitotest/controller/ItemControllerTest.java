package com.sky.mockitotest.mockitotest.controller;

import com.sky.mockitotest.mockitotest.business.ItemBusinessService;
import com.sky.mockitotest.mockitotest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        //call "/hello-world"
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"qty\":100}"))
                .andReturn();

        //verify "/Hello World"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {
        when(itemBusinessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2",10,10));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id: 2,name:Item2,price:10,qty:10}"))
                .andReturn();

        //verify "/Hello World"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2, "Item2",10,10),
                        new Item(3, "Item3",10,10)));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-item-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 2,name:Item2,price:10,qty:10},{id: 3,name:Item3,price:10,qty:10}] "))
                .andReturn();

        //verify "/Hello World"
        //assertEquals("Hello World",result.getResponse().getContentAsString());
    }
}
