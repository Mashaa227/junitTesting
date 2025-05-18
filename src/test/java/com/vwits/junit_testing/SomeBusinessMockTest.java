package com.vwits.junit_testing;

import com.vwits.junit_testing.business.SomeBusinessImpl;
import com.vwits.junit_testing.data.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

 class SomeBusinessMockTest {

     SomeBusinessImpl business = new SomeBusinessImpl();
     SomeDataService someDataService = mock(SomeDataService.class);

     @BeforeEach
     void setUp() {
         business.setSomeDataService(someDataService);
     }

    @Test
    void testCalculateSumUsingDataService() {
        when(someDataService.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,business.calculateSumUsingDataService());
    }

     @Test
     void testCalculateSumUsingDataServiceOneElement() {
         when(someDataService.retrieveAllData()).thenReturn(new int[]{5});
         assertEquals(5,business.calculateSumUsingDataService());
     }

     @Test
     void testCalculateSumUsingDataServiceEmpty() {
         when(someDataService.retrieveAllData()).thenReturn(new int[]{});
         assertEquals(0,business.calculateSumUsingDataService());
     }
}
