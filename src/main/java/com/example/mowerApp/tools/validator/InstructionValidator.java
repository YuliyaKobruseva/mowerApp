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
}

