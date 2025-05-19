package com.vwits.junit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

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
}
