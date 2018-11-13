package com.voam.springbootmockito.controller;

import com.voam.springbootmockito.domain.Item;
import com.voam.springbootmockito.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem() throws Exception {
        /*
           * Build the GET request
         */
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        /**
         * Do the actual request
         */
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "id: 1,\n" +
                        "name: \"Ball\",\n" +
                        "price: 10,\n" +
                        "quantity: 100\n" +
                        "}"))
                .andReturn();

        /**
         * Explore Strict and other JSON assert validations. We don't need
         * to have ESCAPE characters.
         *
         */
        //JSONAssert.assertEquals("","",true);
       //JSONAssert.assertEquals("","",false);
    }

    @Test
    public void itemFromBusinessLayerTest() throws Exception {
        /*
         * Build the GET request
         */
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        when(itemBusinessService.retrieveHardCodedItem())
                .thenReturn(new Item(1,"Ball",10,200));
        /**
         * Do the actual request
         */
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\n" +
                        "id: 1,\n" +
                        "name: \"Ball\",\n" +
                        "price: 10,\n" +
                        "quantity: 200\n" +
                        "}"))
                .andReturn();

        /**
         * Explore Strict and other JSON assert validations. We don't need
         * to have ESCAPE characters.
         *
         */
        //JSONAssert.assertEquals("","",true);
        //JSONAssert.assertEquals("","",false);
    }
}