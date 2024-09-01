package com.example.mowerApp.unit.tools.validator;

import com.example.mowerApp.tools.validator.PlateauSizeValidator;
import org.junit.Test;

public class PlateauSizeValidatorUnitTest {

    @Test
    public void givenValidPlateauSize_whenValidatePlateauSize_thenPassesValidation() {
        String[] plateauSizeParts = {"5", "5"};
        PlateauSizeValidator.validatePlateauSize(plateauSizeParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidPlateauSizeLength_whenValidatePlateauSize_thenThrowsIllegalArgumentException() {
        String[] plateauSizeParts = {"5"};
        PlateauSizeValidator.validatePlateauSize(plateauSizeParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericWidth_whenValidatePlateauSize_thenThrowsIllegalArgumentException() {
        String[] plateauSizeParts = {"A", "5"};
        PlateauSizeValidator.validatePlateauSize(plateauSizeParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNonNumericHeight_whenValidatePlateauSize_thenThrowsIllegalArgumentException() {
        String[] plateauSizeParts = {"5", "B"};
        PlateauSizeValidator.validatePlateauSize(plateauSizeParts);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyInput_whenValidatePlateauSize_thenThrowsIllegalArgumentException() {
        String[] plateauSizeParts = {};
        PlateauSizeValidator.validatePlateauSize(plateauSizeParts);
    }
}


