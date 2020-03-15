package com.sky.mockitotest.mockitotest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDiffValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameters() {
        when(mock.get(0)).thenReturn("parm");
        assertEquals("parm", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("parm");
        assertEquals("parm", mock.get(0));
        assertEquals("parm", mock.get(1));
    }

    @Test
    public void verificationBasics() {
        //SUT
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        //verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mock.add("test");

        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("test", captor.getValue());
    }

    @Test
    public void multiArgumentCapturing() {
        //SUT
        mock.add("test");
        mock.add("test2");

        //verify
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("test", allValues.get(0));
        assertEquals("test2", allValues.get(1));
    }
}
