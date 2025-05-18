package com.vwits.junit_testing;

import com.vwits.junit_testing.business.SomeBusinessImpl;
import com.vwits.junit_testing.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class SomeBusinessMockTest {

     SomeBusinessImpl business = new SomeBusinessImpl();
     SomeDataService someDataService = mock(SomeDataService.class);

    @Test
    void testCalculateSumUsingDataService() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        business.setSomeDataService(someDataService);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult,actualResult);
    }

     @Test
     void testCalculateSumUsingDataServiceOneElement() {
         when(someDataService.retrieveAllData()).thenReturn(new int[]{5});
         business.setSomeDataService(someDataService);
         int actualResult = business.calculateSumUsingDataService();
         int expectedResult = 5;
         assertEquals(expectedResult,actualResult);
     }

     @Test
     void testCalculateSumUsingDataServiceEmpty() {
         when(someDataService.retrieveAllData()).thenReturn(new int[]{});
         business.setSomeDataService(someDataService);
         int actualResult = business.calculateSumUsingDataService();
         int expectedResult = 0;
         assertEquals(expectedResult,actualResult);
     }
}
