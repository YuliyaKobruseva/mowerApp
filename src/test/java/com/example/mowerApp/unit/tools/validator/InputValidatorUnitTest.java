package com.example.mowerApp.unit.tools.validator;

import com.example.mowerApp.tools.validator.InputValidator;
import org.junit.Test;

import java.util.Scanner;
import java.util.function.Consumer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class InputValidatorUnitTest {

    @Test
    public void givenValidInputArray_whenGetValidatedInputArray_thenReturnsArray() {
        Scanner scanner = new Scanner("5 5\n");
        Consumer<String[]> validator = mock(Consumer.class);

        String[] result = InputValidator.getValidatedInputArray(scanner, validator);

        assertNotNull(result);
        assertArrayEquals(new String[]{"5", "5"}, result);
        verify(validator).accept(result);  // Verifica que el validador se llama correctamente
    }

    @Test
    public void givenInvalidInputArray_whenGetValidatedInputArray_thenReturnsNull() {
        Scanner scanner = new Scanner("invalid input\n");
        Consumer<String[]> validator = mock(Consumer.class);
        doThrow(new IllegalArgumentException("Invalid input")).when(validator).accept(any(String[].class));

        String[] result = InputValidator.getValidatedInputArray(scanner, validator);

        assertNull(result);
        verify(validator).accept(any(String[].class));  // Verifica que el validador se llama correctamente
    }

    @Test
    public void givenEmptyInput_whenGetValidatedInputArray_thenReturnsNull() {
        Scanner scanner = new Scanner("\n");
        Consumer<String[]> validator = mock(Consumer.class);

        String[] result = InputValidator.getValidatedInputArray(scanner, validator);

        assertNull(result);
        verify(validator, never()).accept(any(String[].class));  // Verifica que el validador no se llama
    }

    @Test
    public void givenValidInputString_whenGetValidatedInputString_thenReturnsString() {
        Scanner scanner = new Scanner("LMLMLMLMM\n");
        Consumer<String> validator = mock(Consumer.class);

        String result = InputValidator.getValidatedInputString(scanner, validator);

        assertNotNull(result);
        assertEquals("LMLMLMLMM", result);
        verify(validator).accept(result);  // Verifica que el validador se llama correctamente
    }

    @Test
    public void givenInvalidInputString_whenGetValidatedInputString_thenReturnsNull() {
        Scanner scanner = new Scanner("invalid\n");
        Consumer<String> validator = mock(Consumer.class);
        doThrow(new IllegalArgumentException("Invalid input")).when(validator).accept(anyString());

        String result = InputValidator.getValidatedInputString(scanner, validator);

        assertNull(result);
        verify(validator).accept(anyString());  // Verifica que el validador se llama correctamente
    }

    @Test
    public void givenEmptyInput_whenGetValidatedInputString_thenReturnsNull() {
        Scanner scanner = new Scanner("\n");
        Consumer<String> validator = mock(Consumer.class);

        String result = InputValidator.getValidatedInputString(scanner, validator);

        assertNull(result);
        verify(validator, never()).accept(anyString());  // Verifica que el validador no se llama
    }
}

