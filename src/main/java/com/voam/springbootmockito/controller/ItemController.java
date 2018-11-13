package com.voam.springbootmockito.controller;

import com.voam.springbootmockito.domain.Item;
import com.voam.springbootmockito.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100 );
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return businessService.retrieveHardCodedItem();
    }
}
