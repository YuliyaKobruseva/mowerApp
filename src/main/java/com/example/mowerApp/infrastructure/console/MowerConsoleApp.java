package com.example.mowerApp.infrastructure.console;

import com.example.mowerApp.application.service.MowerService;
import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.domain.model.enums.Instruction;
import com.example.mowerApp.tools.validator.DirectionValidator;
import com.example.mowerApp.tools.validator.InstructionValidator;

import java.util.Scanner;

public class MowerConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Enter the upper-right coordinates of the plateau:");
            int plateauWidth = scanner.nextInt();
            int plateauHeight = scanner.nextInt();
            Plateau plateau = Plateau.getInstance(plateauWidth, plateauHeight);

            MowerService mowerService = new MowerService(plateau);

            System.out.println("Enter the initial position of the mower (x y direction):");
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            String directionInput = scanner.next();
            Direction startDirection = DirectionValidator.validateDirection(directionInput);

            Mower mower = new Mower(startX, startY, startDirection);

            System.out.println("Enter the series of instructions (L, R, M):");
            String instructions = scanner.next();

            // Validación de instrucciones y ejecución
            for (char instructionChar : instructions.toCharArray()) {
                Instruction instruction = InstructionValidator.validateInstruction(instructionChar);
                mower.executeInstruction(instruction, plateau);
            }

            System.out.println("Final position and direction of the mower:");
            System.out.println(mower.getX() + " " + mower.getY() + " " + mower.getDirection());

        } catch (InvalidDirectionException | InvalidInstructionException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
