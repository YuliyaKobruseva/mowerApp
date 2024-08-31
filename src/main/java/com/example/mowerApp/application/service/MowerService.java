package com.example.mowerApp.application.service;

import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.Plateau;

public class MowerService {
    private final Plateau plateau;

    public MowerService(Plateau plateau) {
        this.plateau = plateau;
    }

    public void moveMower(Mower mower, String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L': mower.turnLeft(); break;
                case 'R': mower.turnRight(); break;
                case 'M': mower.moveForward(plateau); break;
                default: throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }
}

