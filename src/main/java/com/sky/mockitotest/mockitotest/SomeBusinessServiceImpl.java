package com.sky.mockitotest.mockitotest;

import com.sky.mockitotest.mockitotest.data.SomeDataService;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class SomeBusinessServiceImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] inpArr) {
        return Arrays.stream(inpArr).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrievAll()).reduce(Integer::sum).orElse(0);
    }
}
