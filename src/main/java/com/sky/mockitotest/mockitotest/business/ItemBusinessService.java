package com.sky.mockitotest.mockitotest.business;

import com.sky.mockitotest.mockitotest.data.ItemRepository;
import com.sky.mockitotest.mockitotest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();

        for (Item item:items)
        {
            item.setValue(item.getPrice() * item.getQty());
        }

        return itemRepository.findAll();
    }
}
