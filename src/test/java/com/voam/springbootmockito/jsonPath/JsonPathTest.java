package com.voam.springbootmockito.jsonPath;

import org.junit.Test;

public class JsonPathTest {

    @Test
    public void learning() {

        String responseFromService = "[\n" +
                "{\n" +
                "id: 1,\n" +
                "name: \"Serval\",\n" +
                "price: 4,\n" +
                "quantity: 100,\n" +
                "value: 400\n" +
                "},\n" +
                "{\n" +
                "id: 2,\n" +
                "name: \"African darter\",\n" +
                "price: 14,\n" +
                "quantity: 68,\n" +
                "value: 952\n" +
                "},\n" +
                "{\n" +
                "id: 3,\n" +
                "name: \"Caracara (unidentified)\",\n" +
                "price: 15,\n" +
                "quantity: 26,\n" +
                "value: 390\n" +
                "}]";

    }
}
