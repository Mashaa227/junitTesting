package com.vwits.junit_testing.business;

import com.vwits.junit_testing.data.SomeDataService;
import lombok.Setter;

@Setter
public class SomeBusinessImpl {

    private SomeDataService someDataService;


    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value: data) {

            sum += value;
        }
        return sum;

    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value: data) {
            sum += value;
        }
        return sum;
    }


}
