package com.voam.springbootmockito.service;

import com.voam.springbootmockito.data.ItemRepository;
import com.voam.springbootmockito.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    ItemBusinessService itemBusinessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retrieveAllItems() {

        /*
        List<Item> items = itemRepository.findAll();

        for(Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
       return items;
         */
        List<Item> dummyListOfItems = new ArrayList<>();
        dummyListOfItems.add(new Item(1,"Ball",10,200));
        dummyListOfItems.add(new Item(2,"Cat",12,300));
        dummyListOfItems.add(new Item(3,"Dog",14,400));

        when(itemRepository.findAll()).thenReturn(dummyListOfItems);

        List<Item> itemList = itemBusinessService.retrieveAllItems();

        assertEquals(3600,itemList.get(1).getValue());
        assertEquals(3,itemList.size());

    }
}