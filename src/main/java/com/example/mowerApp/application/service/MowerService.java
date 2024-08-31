package com.example.mowerApp.application.service;

import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Instruction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MowerService {
    private static final Logger logger = LoggerFactory.getLogger(MowerService.class);
    private final Plateau plateau;

    public MowerService(Plateau plateau) {
        this.plateau = plateau;
    }

    public void moveMower(Mower mower, String instructions, Plateau plateau, ObstacleManager obstacleManager) {
        for (char instructionChar : instructions.toCharArray()) {
            try {
                Instruction instruction = Instruction.valueOf(String.valueOf(instructionChar));
                mower.executeInstruction(instruction, plateau, obstacleManager);
            } catch (IllegalArgumentException e) {
                logger.error("Invalid instruction: {} - Skipping", instructionChar, e);
                throw new InvalidInstructionException("Invalid instruction: " + instructionChar);
            }
        }
    }
}


