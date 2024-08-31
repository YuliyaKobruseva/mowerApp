package com.example.mowerApp.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RequiredArgsConstructor
public class ObstacleManager {
    private final Set<Obstacle> obstacles = new HashSet<>();
    private final Plateau plateau;

    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new Obstacle(x, y));
    }

    public void addObstacle(int x, int y) {
        if (plateau.isInside(x, y)) {
            obstacles.add(new Obstacle(x, y));
        } else {
            throw new IllegalArgumentException("Obstacle position out of bounds");
        }
    }

    public void generateRandomObstacles(int numberOfObstacles) {
        Random random = new Random();
        while (obstacles.size() < numberOfObstacles) {
            int x = random.nextInt(plateau.getWidth() + 1);
            int y = random.nextInt(plateau.getHeight() + 1);
            if (!hasObstacle(x, y)) {
                addObstacle(x, y);
            }
        }
    }
}

