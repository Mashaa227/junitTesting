package com.vwits.junit_testing;

import com.vwits.junit_testing.business.SomeBusinessImpl;
import com.vwits.junit_testing.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//using stub implementation
class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneElementStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

 class SomeBusinessStudTest {

    @Test
     void calculateSumUsingDataService() {

        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);

    }

     @Test
     void calculateSumUsingDataServiceEmpty() {

         SomeBusinessImpl business = new SomeBusinessImpl();
         business.setSomeDataService(new SomeDataServiceOneElementStub());
         int actualResult = business.calculateSumUsingDataService();
         int expectedResult = 5;
         assertEquals(expectedResult,actualResult);

     }

     @Test
     void calculateSumUsingDataServiceOneElement() {

         SomeBusinessImpl business = new SomeBusinessImpl();
         business.setSomeDataService(new SomeDataServiceEmptyStub());
         int actualResult = business.calculateSumUsingDataService();
         int expectedResult = 0;
         assertEquals(expectedResult,actualResult);

     }
}
