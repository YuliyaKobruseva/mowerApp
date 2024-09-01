package com.example.mowerApp.domain.model;

import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.domain.model.enums.Instruction;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Mower {
    private int x;
    private int y;
    private Direction direction;
    private final List<String> movementLog = new ArrayList<>();

    public Mower(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        logPosition();
    }

    public void executeInstruction(Instruction instruction, Plateau plateau, ObstacleManager obstacleManager) {
        switch (instruction) {
            case L:
                this.direction = direction.turnLeft();
                logPosition();
                break;
            case R:
                this.direction = direction.turnRight();
                logPosition();
                break;
            case M:
                moveForward(plateau, obstacleManager);
                logPosition();
                break;
            default:
                throw new IllegalArgumentException("Invalid instruction: " + instruction);
        }
    }

    public void moveForward(Plateau plateau, ObstacleManager obstacleManager) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case N:
                newY++;
                break;
            case E:
                newX++;
                break;
            case S:
                newY--;
                break;
            case W:
                newX--;
                break;
        }

        if (plateau.isInside(newX, newY) && !obstacleManager.hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            System.out.println("Move blocked by obstacle or boundary at (" + newX + ", " + newY + ")");
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void logPosition() {
        movementLog.add("Position: (" + x + ", " + y + "), Direction: " + direction);
    }
}

