package com.example.mowerApp.application.service;

import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Instruction;

public class MowerService {
    private final Plateau plateau;

    public MowerService(Plateau plateau) {
        this.plateau = plateau;
    }

    public void moveMower(Mower mower, String instructions) {
        for (char instructionChar : instructions.toCharArray()) {
            Instruction instruction = Instruction.fromChar(instructionChar);
            mower.executeInstruction(instruction, plateau);
        }
    }
}


