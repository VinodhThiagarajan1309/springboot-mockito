package com.voam.springbootmockito.data;

import com.voam.springbootmockito.data.ItemRepository;
import com.voam.springbootmockito.domain.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void test_findAllMethod() {
        List<Item> items = itemRepository.findAll();
        assertEquals(1013, items.size());
    }

}