package com.example.mowerApp.tools.validator;

import com.example.mowerApp.domain.model.enums.Direction;

public class MowerPositionValidator {

    public static void validateMowerPosition(String[] positionParts) {
        if (positionParts.length != 3 || !positionParts[0].matches("\\d+") || !positionParts[1].matches("\\d+")) {
            throw new IllegalArgumentException("Invalid input: The position must contain two numbers and a direction.");
        }
        DirectionValidator.validateDirection(positionParts[2]);
    }
}

