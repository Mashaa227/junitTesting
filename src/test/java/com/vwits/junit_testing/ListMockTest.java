package com.vwits.junit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@SuppressWarnings("unused")
@ExtendWith(MockitoExtension.class) // ✅ Enable Mockito support for JUnit 5
class ListMockTest {

    @Mock
    List<String> mock;

    @Test
    void test() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("I am Mashak");
        assertEquals("I am Mashak", mock.get(0));
        assertNull(mock.get(1));
    }

    /*Argument Matcher anyInt()*/
    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("I am Mashak");
        assertEquals("I am Mashak", mock.get(0));
        assertEquals("I am Mashak", mock.get(1));
    }

    @Test
    void verificationBasics(){
        //SUT
         String value1 = mock.get(0);
         String value2 = mock.get(1);

        //Verification
        verify(mock).get(0);
        verify(mock,times(2)).get(anyInt());
        verify(mock,atLeast(1)).get(anyInt());
        verify(mock,atLeastOnce()).get(anyInt());
        verify(mock,atMost(2)).get(anyInt());
        verify(mock,never()).get(2);
    }

    /*argument capturing */
    void argumentCapturing(){
        //SUT
        mock.add("SomeString");

        //Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("SomeString", captor.getValue());
    }
}
