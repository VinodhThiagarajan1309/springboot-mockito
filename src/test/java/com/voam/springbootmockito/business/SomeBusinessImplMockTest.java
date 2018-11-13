package com.voam.springbootmockito.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.voam.springbootmockito.data.SumDataService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

    @InjectMocks
    SomeBusinessImpl someBusiness;

    /**
     * Mock the member variable
     */
    @Mock
    SumDataService sumDataServiceMock;


    @Before
    public void setUp(){
        /*someBusiness = new SomeBusinessImpl();
        sumDataServiceMock = mock(SumDataService.class);
        someBusiness.setSumDataService(sumDataServiceMock);*/
    }

    @Test
    public void calculateSumUsingDataService(){

        /**
         * When some method is called on the mocked variable.
         * Direct it to return something using the When and then return
         */
        when(sumDataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});
        assertEquals(6,someBusiness.calculateSumUsingDataService());
    }


    @Test
    public void calculateUsingDataServiceEmptyArray() {

        /**
         * When some method is called in the mocked variable.
         * Direct it to return something using the When and then return
         */
        when(sumDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(0,someBusiness.calculateSumUsingDataService());
    }

    @Test
    public void calculateJustOneValueUsingDataService() {

        /**
         * When some method is called in the mocked variable.
         * Direct it to return something using the When and then return
         */
        when(sumDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        assertEquals(5,someBusiness.calculateSumUsingDataService());
    }

    
}
