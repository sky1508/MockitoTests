package com.sky.mockitotest.mockitotest.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"qty\":100}";

    @Test
    public void JsonAssert_Strict_True_ExactMatchExceptForSpaces() throws JSONException {
        //String expectedRespose="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"qty\":100}";;
        //JSONAssert.assertEquals(expectedRespose, actualResponse, false);

        String expectedRespose="{\"id\":1,\"name\":\"Ball\"}";;
        JSONAssert.assertEquals(expectedRespose, actualResponse, true);
    }

    @Test
    public void JsonAssert_Strict_False_ExactMatchExceptForSpaces() throws JSONException {
        String expectedRespose="{\"id\":1,\"name\":\"Ball\"}";;
        JSONAssert.assertEquals(expectedRespose, actualResponse, false);
    }

    @Test
    public void JsonAssert_WithoutEscapeChar() throws JSONException {
        // \ is needed when you have space in the values
        String expectedRespose="{id:1,name:Ball,price:10}";
        JSONAssert.assertEquals(expectedRespose, actualResponse, false);
    }
}
