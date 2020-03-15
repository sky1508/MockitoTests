package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.business.ItemBusinessService;
import com.sky.mockitotest.mockitotest.data.ItemRepository;
import com.sky.mockitotest.mockitotest.data.SomeDataService;
import com.sky.mockitotest.mockitotest.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ItemBusinessServiceMockTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    ItemRepository itemRepository;

    @Test
    public void retrieveAllItems_basic() {

        //dataServiceMock retrievAll new int[] {1, 2, 3}
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(new Item(2, "Item2",10,10),
                        new Item(3, "Item3",20,10)));

        List<Item> item = itemBusinessService.retrieveAllItems();

        Assert.assertEquals(100, item.get(0).getValue());
        Assert.assertEquals(200, item.get(1).getValue());
    }

}
