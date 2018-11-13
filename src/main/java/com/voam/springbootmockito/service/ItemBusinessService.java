package com.voam.springbootmockito.service;

import com.voam.springbootmockito.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {

    public Item retrieveHardCodedItem() {
        return new Item(1, "Ball", 10, 100 );
    }
}
