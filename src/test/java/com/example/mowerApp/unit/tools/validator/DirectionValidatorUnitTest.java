package com.example.mowerApp.unit.tools.validator;

import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.tools.validator.DirectionValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionValidatorUnitTest {
    @Test
    public void givenValidDirectionInput_whenValidateDirection_thenReturnsDirection() {
        assertEquals(Direction.N, DirectionValidator.validateDirection("N"));
        assertEquals(Direction.E, DirectionValidator.validateDirection("E"));
        assertEquals(Direction.S, DirectionValidator.validateDirection("S"));
        assertEquals(Direction.W, DirectionValidator.validateDirection("W"));
    }

    @Test
    public void givenValidLowerCaseDirectionInput_whenValidateDirection_thenReturnsDirection() {
        assertEquals(Direction.N, DirectionValidator.validateDirection("n"));
        assertEquals(Direction.E, DirectionValidator.validateDirection("e"));
        assertEquals(Direction.S, DirectionValidator.validateDirection("s"));
        assertEquals(Direction.W, DirectionValidator.validateDirection("w"));
    }

    @Test(expected = InvalidDirectionException.class)
    public void givenInvalidDirectionInput_whenValidateDirection_thenThrowsInvalidDirectionException() {
        DirectionValidator.validateDirection("X");
    }

    @Test(expected = InvalidDirectionException.class)
    public void givenEmptyDirectionInput_whenValidateDirection_thenThrowsInvalidDirectionException() {
        DirectionValidator.validateDirection("");
    }
}
