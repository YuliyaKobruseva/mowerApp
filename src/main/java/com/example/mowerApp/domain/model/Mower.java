package com.example.mowerApp.domain.model;

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

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

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
}

