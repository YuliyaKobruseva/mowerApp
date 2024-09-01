package com.example.mowerApp.unit.tools.validator;

import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.tools.validator.MowerPositionValidator;
import org.junit.Test;

public class MowerPositionValidatorUnitTest {

    @Test
    public void givenValidPosition_whenValidateMowerPosition_thenPassesValidation() {
        String[] positionParts = {"1", "2", "N"};
        MowerPositionValidator.validateMowerPosition(positionParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidPositionLength_whenValidateMowerPosition_thenThrowsIllegalArgumentException() {
        String[] positionParts = {"1", "2"};
        MowerPositionValidator.validateMowerPosition(positionParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericXCoordinate_whenValidateMowerPosition_thenThrowsIllegalArgumentException() {
        String[] positionParts = {"A", "2", "N"};
        MowerPositionValidator.validateMowerPosition(positionParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericYCoordinate_whenValidateMowerPosition_thenThrowsIllegalArgumentException() {
        String[] positionParts = {"1", "B", "N"};
        MowerPositionValidator.validateMowerPosition(positionParts);
    }

    @Test(expected = InvalidDirectionException.class)
    public void givenInvalidDirection_whenValidateMowerPosition_thenThrowsInvalidDirectionException() {
        String[] positionParts = {"1", "2", "X"};
        MowerPositionValidator.validateMowerPosition(positionParts);
    }
}


