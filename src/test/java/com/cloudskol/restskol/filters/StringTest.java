package com.cloudskol.restskol.filters;

import org.junit.Test;

/**
 * @author tham
 */

public class StringTest {
    @Test
    public void testReplce() {
        String value = "books/v1";
        if (value.contains("/v1")) {
            value = value.replace("/v1", "/v2");
        }

        System.out.println("Now value: " + value);
    }
}
