package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.data.SomeDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//Stubs
class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retrievAll() {
        return new int[] {1, 2, 3};
    }
}

class SomeDataServiceStub2 implements SomeDataService {

    @Override
    public int[] retrievAll() {
        return new int[] {};
    }
}

@RunWith(SpringRunner.class)
@SpringBootTest
public class SomeBusinessServiceImplStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessServiceImpl sb = new SomeBusinessServiceImpl();
        sb.setSomeDataService(new SomeDataServiceStub());
        int actualResult = sb.calculateSumUsingDataService();
        int expectedResult =  6;

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessServiceImpl sb = new SomeBusinessServiceImpl();
        sb.setSomeDataService(new SomeDataServiceStub2());
        int actualResult = sb.calculateSumUsingDataService();
        int expectedResult =  0;

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_one() {
        SomeBusinessServiceImpl sb = new SomeBusinessServiceImpl();
        int actualResult = sb.calculateSum(new int[] {1});
        int expectedResult =  1;

        Assert.assertEquals(expectedResult, actualResult);
    }
}
