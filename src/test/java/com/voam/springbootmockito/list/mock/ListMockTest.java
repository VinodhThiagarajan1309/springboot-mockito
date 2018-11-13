package com.voam.springbootmockito.list.mock;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mockedList = mock(List.class);

    @Test
    public void size_basic(){
        when(mockedList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockedList.size());
    }

    @Test
    public void returnDifferentValues(){

        when(mockedList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,mockedList.size());
        assertEquals(10,mockedList.size());
    }

    @Test
    public void returnWithParameters(){

        when(mockedList.get(0)).thenReturn("voam");
        assertEquals("voam",mockedList.get(0));

    }

    @Test
    public void returnWithGenericParameters(){

        when(mockedList.get(anyInt())).thenReturn("voam");
        assertEquals("voam",mockedList.get(15));

    }

    @Test public void verifactionBasics() {
        String value = mockedList.get(0);

        verify(mockedList,times(1)).get(0);
    }

    @Test
    public void argumentCapturing() {

        mockedList.add("SomeStringValue");
        mockedList.add("SomeStringValue2");
       // mockedList.add("SomeStringValue2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockedList,times(2)).add(captor.capture());
       /// verify(mockedList).add(captor.capture());
        //verify(mockedList).add(captor.capture());
        //verify(mockedList).add(captor.capture());

        assertEquals("SomeStringValue", captor.getValue());
    }

    @Test
    public void Spying() {


        ArrayList<String> arrayListSpy = spy(ArrayList.class);

        arrayListSpy.add("Vinodh");
        arrayListSpy.add("Priya");
        arrayListSpy.add("Mrithula");
        arrayListSpy.add("Meghna");

        System.out.println(arrayListSpy.size());

        when(arrayListSpy.size()).thenReturn(25);

        System.out.println(arrayListSpy.size());

        verify(arrayListSpy,times(1)).add("Priya");


    }

}
