package com.example.mowerApp.tools.validator;

import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.domain.model.enums.Direction;

public class DirectionValidator {

    public static Direction validateDirection(String directionInput) {
        try {
            return Direction.valueOf(directionInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidDirectionException("Invalid direction: " + directionInput + ". Valid directions are N, E, S, W.");
        }
    }
}
