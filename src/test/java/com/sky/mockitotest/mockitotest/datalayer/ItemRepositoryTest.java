package com.sky.mockitotest.mockitotest.datalayer;

import com.sky.mockitotest.mockitotest.data.ItemRepository;
import com.sky.mockitotest.mockitotest.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll(){
            List<Item> item = itemRepository.findAll();
            assertEquals(3, item.size());
    }
}

