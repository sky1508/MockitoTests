package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.data.SomeDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SomeBusinessServiceImplMockTest {

    @InjectMocks
    SomeBusinessServiceImpl someBusinessService;

    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {

        //dataServiceMock retrievAll new int[] {1, 2, 3}
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {1,2,3});
        Assert.assertEquals(6, someBusinessService.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_empty() {
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {});
        Assert.assertEquals(0, someBusinessService.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_one() {
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {1});
        Assert.assertEquals(1, someBusinessService.calculateSumUsingDataService());
    }
}
