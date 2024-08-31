package com.example.mowerApp.tools.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;
import java.util.function.Consumer;

public class InputValidator {

    private static final Logger logger = LoggerFactory.getLogger(InputValidator.class);

    public static String[] getValidatedInputArray(Scanner scanner, Consumer<String[]> validator) {
        if (!scanner.hasNextLine()) return null;

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return null;

        String[] parts = input.split("\\s+");
        try {
            validator.accept(parts);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return null;
        }
        return parts;
    }

    public static String getValidatedInputString(Scanner scanner, Consumer<String> validator) {
        if (!scanner.hasNextLine()) return null;

        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return null;

        try {
            validator.accept(input);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return null;
        }
        return input;
    }
}

