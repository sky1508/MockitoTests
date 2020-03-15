package com.sky.mockitotest.mockitotest.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers = Arrays.asList(12, 15, 45);

        //assertThat(numbers, hasSize(3));
        assertThat(numbers).hasSize(3)
                .contains(12,15)
                .allMatch(x -> x > 10)
                .allMatch(x -> x < 100);



        /*assertThat(numbers, hasItems(12,45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(50)));

        assertThat("", isEmptyString());
        assertThat("ABCDE", containsString("BCD"));
        assertThat("ABCDE", startsWith("AB"));
        assertThat("ABCDE", endsWith("DE"));*/
    }
}
