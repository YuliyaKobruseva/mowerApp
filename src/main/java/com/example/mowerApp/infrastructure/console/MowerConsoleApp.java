package com.example.mowerApp.infrastructure.console;

import com.example.mowerApp.application.service.MowerService;
import com.example.mowerApp.domain.exception.InvalidDirectionException;
import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.tools.validator.DirectionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MowerConsoleApp {
    private static final Logger logger = LoggerFactory.getLogger(MowerConsoleApp.class);
    private static final int DEFAULT_OBSTACLE_COUNT = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Enter plateau size (e.g., '5 5'), followed by each mower's position (e.g., '1 2 N') and movement instructions (e.g., 'LMLMLMM'). Leave an empty line to finish.");

            // Leer la primera línea para el tamaño del plateau y validarla
            String plateauSizeInput = scanner.nextLine().trim();
            String[] plateauSizeParts = plateauSizeInput.split("\\s+");

            if (plateauSizeParts.length != 2 || !plateauSizeParts[0].matches("\\d+")
                    || !plateauSizeParts[1].matches("\\d+")) {
                throw new IllegalArgumentException("Invalid input: The first line must contain exactly two numbers. For example: 5 5");
            }

            int plateauWidth = Integer.parseInt(plateauSizeParts[0]);
            int plateauHeight = Integer.parseInt(plateauSizeParts[1]);

            Plateau plateau = Plateau.getInstance(plateauWidth, plateauHeight);
            ObstacleManager obstacleManager = new ObstacleManager(plateau);

            /* obstacleManager.generateRandomObstacles(DEFAULT_OBSTACLE_COUNT);
            System.out.println(DEFAULT_OBSTACLE_COUNT + " obstacles have been randomly placed on the plateau."); */

            List<Mower> mowers = new ArrayList<>();

            while (scanner.hasNextLine()) {
                // Leer la línea para la posición inicial del cortacésped
                String positionInput = scanner.nextLine().trim();
                if (positionInput.isEmpty()) {
                    break; // Si la línea está vacía, terminar el bucle
                }

                String[] positionParts = positionInput.split("\\s+");
                if (positionParts.length != 3) {
                    logger.error("Invalid position input: '{}'", positionInput);
                    continue; // O manejar de alguna otra manera
                }

                int startX = Integer.parseInt(positionParts[0]);
                int startY = Integer.parseInt(positionParts[1]);
                Direction startDirection = DirectionValidator.validateDirection(positionParts[2]);

                Mower mower = new Mower(startX, startY, startDirection);
                mowers.add(mower);

                // Leer la línea para las instrucciones del cortacésped
                if (scanner.hasNextLine()) {
                    String instructions = scanner.nextLine().trim().toUpperCase();

                    MowerService mowerService = new MowerService(plateau);
                    mowerService.moveMower(mower, instructions, plateau, obstacleManager);
                }
            }

            // Mostrar todos los logs y posiciones finales después de que todos los cortacéspedes terminen
            for (int i = 0; i < mowers.size(); i++) {
                Mower mower = mowers.get(i);
                logger.info("Final position and direction of mower {}:", (i + 1));
                logger.info("{} {} {}", mower.getX(), mower.getY(), mower.getDirection());

                logger.info("Movement log for mower {}:", (i + 1));
                mower.getMovementLog().forEach(log -> logger.info(log));
            }
        } catch (IllegalArgumentException | InvalidDirectionException | InvalidInstructionException e) {
            logger.error(e.getMessage(), e);
        } finally {
            scanner.close();
        }
    }
}
