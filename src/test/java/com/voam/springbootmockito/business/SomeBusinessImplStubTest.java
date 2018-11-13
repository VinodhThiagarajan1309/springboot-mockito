package com.voam.springbootmockito.business;

import com.voam.springbootmockito.data.SumDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class SomeDataServiceStub implements SumDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1,2,3};
    }
}

class SomeDataServiceStubEmptyArray implements SumDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}


class SomeDataServiceStubJustOneElement implements SumDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{5};
    }
}

public class SomeBusinessImplStubTest {

    @Test
    public void calculateSumUsingDataService(){

        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSumDataService(new SomeDataServiceStub());
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult,result);
    }


    @Test
    public void calculateUsingDataServiceEmptyArray() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSumDataService(new SomeDataServiceStubEmptyArray());
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 0;

        assertEquals(expectedResult,result);
    }

    @Test
    public void calculateJustOneValueUsingDataService() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSumDataService(new SomeDataServiceStubJustOneElement());
        int result = someBusiness.calculateSumUsingDataService();
        int expectedResult = 5;

        assertEquals(expectedResult,result);
    }

    
}
