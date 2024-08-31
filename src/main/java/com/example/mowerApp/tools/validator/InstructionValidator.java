package com.example.mowerApp.tools.validator;


import com.example.mowerApp.domain.model.enums.Instruction;

public class InstructionValidator {

    public static Instruction validateInstruction(char instructionChar) {
        try {
            return Instruction.fromChar(instructionChar);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid instruction: " + instructionChar + ". Valid instructions are L, R, M.");
        }
    }

    public static void validateInstructionsMatches(String instructions) {
        if (!instructions.toUpperCase().matches("[LRM]+")) {
            throw new IllegalArgumentException("Invalid input: Instructions must only contain the letters L, R, M.");
        }
    }
}

