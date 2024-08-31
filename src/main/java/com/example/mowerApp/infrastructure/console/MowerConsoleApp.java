package com.example.mowerApp.infrastructure.console;

import com.example.mowerApp.application.service.MowerService;
import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.tools.validator.InputValidator;
import com.example.mowerApp.tools.validator.InstructionValidator;
import com.example.mowerApp.tools.validator.MowerPositionValidator;
import com.example.mowerApp.tools.validator.PlateauSizeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MowerConsoleApp {
    private static final Logger logger = LoggerFactory.getLogger(MowerConsoleApp.class);

    public static void main(String[] args) {
        new MowerConsoleApp().run();
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info("Enter plateau size (e.g., '5 5'), followed by each mower's position and instructions. Leave an empty line to finish.");

            Plateau plateau = readPlateau(scanner);
            ObstacleManager obstacleManager = new ObstacleManager(plateau);

            List<Mower> mowers = readMowersAndInstructions(scanner, plateau, obstacleManager);

            displayResults(mowers);
        } catch (IllegalArgumentException | InvalidDirectionException | InvalidInstructionException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private Plateau readPlateau(Scanner scanner) {
        String[] plateauSizeParts = InputValidator.getValidatedInputArray(scanner, PlateauSizeValidator::validatePlateauSize);
        int plateauWidth = Integer.parseInt(plateauSizeParts[0]);
        int plateauHeight = Integer.parseInt(plateauSizeParts[1]);

        return Plateau.getInstance(plateauWidth, plateauHeight);
    }

    private List<Mower> readMowersAndInstructions(Scanner scanner, Plateau plateau, ObstacleManager obstacleManager) {
        List<Mower> mowers = new ArrayList<>();

        while (true) {
            String[] positionParts = InputValidator.getValidatedInputArray(scanner, MowerPositionValidator::validateMowerPosition);
            if (positionParts == null) break;

            Mower mower = new Mower(
                    Integer.parseInt(positionParts[0]),
                    Integer.parseInt(positionParts[1]),
                    Direction.valueOf(positionParts[2].toUpperCase())
            );
            mowers.add(mower);

            String instructions = InputValidator.getValidatedInputString(scanner, InstructionValidator::validateInstructionsMatches);
            if (instructions != null) {
                new MowerService(plateau).moveMower(mower, instructions.toUpperCase(), plateau, obstacleManager);
            }
        }
        return mowers;
    }

    private void displayResults(List<Mower> mowers) {
        for (int i = 0; i < mowers.size(); i++) {
            Mower mower = mowers.get(i);
            logger.info("Final position and direction of mower {}:", i + 1);
            logger.info("{} {} {}", mower.getX(), mower.getY(), mower.getDirection());

            logger.info("Movement log for mower {}:", i + 1);
            mower.getMovementLog().forEach(log -> logger.info(log));
        }
    }
}
