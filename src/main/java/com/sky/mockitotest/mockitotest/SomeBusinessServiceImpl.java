package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.data.SomeDataService;

public class SomeBusinessServiceImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] inpArr) {
        int sum = 0;

        for (int value: inpArr)
            sum += value;

        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrievAll();
        for (int value: data)
            sum += value;

        return sum;
    }
}
