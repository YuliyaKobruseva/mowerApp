package com.example.mowerApp.tools.validator;

public class PlateauSizeValidator {

    public static void validatePlateauSize(String[] plateauSizeParts) {
        if (plateauSizeParts.length != 2 || !plateauSizeParts[0].matches("\\d+")
                || !plateauSizeParts[1].matches("\\d+")) {
            throw new IllegalArgumentException("Invalid input: The first line must contain exactly two numbers. " +
                    "For example: 5 5");
        }
    }
}
