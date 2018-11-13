package com.voam.springbootmockito.business;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SomeBusinessImplTest {


    @Test
    public void calculateSumBasicScenario(){

        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int result = someBusiness.calculateSum(new int[]{1,2,3});
        int expectedResult = 6;

        assertEquals(expectedResult,result);
    }


    @Test
    public void calculateEmptyArray() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int result = someBusiness.calculateSum(new int[]{});
        int expectedResult = 0;

        assertEquals(expectedResult,result);
    }

    @Test
    public void calculateJustOneValue() {
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int result = someBusiness.calculateSum(new int[]{5});
        int expectedResult = 5;

        assertEquals(expectedResult,result);
    }


}
