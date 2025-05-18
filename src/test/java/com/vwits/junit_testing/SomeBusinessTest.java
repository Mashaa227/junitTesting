package com.vwits.junit_testing;

import com.vwits.junit_testing.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessTest {

    @Test
     void calculateSum_basic(){

        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{1,2,3});
        int  expectedResult = 6;
        assertEquals(expectedResult,result);
    }

    @Test
     void calculateSum_empty(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        int result = business.calculateSum(new int[]{5});
        int expectedResult = 5;
        assertEquals(expectedResult,result);

    }
}
