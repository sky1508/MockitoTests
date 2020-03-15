package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.data.SomeDataService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeBusinessServiceImplMockTest {

    SomeBusinessServiceImpl sb = new SomeBusinessServiceImpl();
    SomeDataService dataServiceMock = mock(SomeDataService.class);

    @Before
    public void before() {
        sb.setSomeDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {

        //dataServiceMock retrievAll new int[] {1, 2, 3}
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {1,2,3});
        Assert.assertEquals(6, sb.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_empty() {
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {});
        Assert.assertEquals(0, sb.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_one() {
        when(dataServiceMock.retrievAll()).thenReturn(new int[] {1});
        Assert.assertEquals(1, sb.calculateSumUsingDataService());
    }
}
