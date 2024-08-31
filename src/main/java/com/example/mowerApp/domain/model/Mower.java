package com.example.mowerApp.domain.model;

import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.domain.model.enums.Instruction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mower {
    private int x;
    private int y;
    private Direction direction;

    public void moveForward(Plateau plateau) {
        switch (direction) {
            case N:
                if (plateau.isInside(x, y + 1)) {
                    y++;
                }
                break;
            case E:
                if (plateau.isInside(x + 1, y)) {
                    x++;
                }
                break;
            case S:
                if (plateau.isInside(x, y - 1)) {
                    y--;
                }
                break;
            case W:
                if (plateau.isInside(x - 1, y)) {
                    x--;
                }
                break;
        }
    }

    public void executeInstruction(Instruction instruction, Plateau plateau) {
        switch (instruction) {
            case L:
                this.direction = direction.turnLeft();
                break;
            case R:
                this.direction = direction.turnRight();
                break;
            case M:
                moveForward(plateau);
                break;
            default:
                throw new IllegalArgumentException("Invalid instruction: " + instruction);
        }
    }
}

