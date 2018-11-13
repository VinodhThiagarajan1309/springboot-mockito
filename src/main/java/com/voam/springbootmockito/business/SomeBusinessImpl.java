package com.voam.springbootmockito.business;

import com.voam.springbootmockito.data.SumDataService;

public class SomeBusinessImpl {

    private SumDataService sumDataService;

    public void setSumDataService(SumDataService sumDataService) {
        this.sumDataService = sumDataService;
    }

    public int calculateSum( int[] data) {

        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService( ) {

        int[] data = sumDataService.retrieveAllData();

        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;
    }
}
