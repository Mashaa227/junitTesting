package com.vwits.junit_testing.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Masha\",\"price\":10,\"quantity\":10}";

    @Test
    void jsonAssert_StrictTure_ExactMatchExceptForSpace() throws JSONException {
        String acceptedResponse = "{\"id\":1,\"name\":\"Masha\",\"price\":10,\"quantity\":10}";
        JSONAssert.assertEquals(acceptedResponse,actualResponse,true);
    }

    @Test
    void jsonAssert_StrictFalse() throws JSONException {
        String acceptedResponse = "{\"id\":1,\"name\":\"Masha\",\"price\":10}";
        JSONAssert.assertEquals(acceptedResponse,actualResponse,false);
    }

    @Test
    void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String acceptedResponse = "{id:1,name:Masha,price:10,quantity:10}";
        JSONAssert.assertEquals(acceptedResponse,actualResponse,false);
    }
}
