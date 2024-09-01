package com.example.mowerApp.domain.model;


import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class ObstacleManager {
    private final Set<Obstacle> obstacles = new HashSet<>();
    private final Plateau plateau;
    private final Set<Mower> mowers = new HashSet<>();


    public boolean hasObstacle(int x, int y) {
        return obstacles.contains(new Obstacle(x, y))|| mowers.stream().anyMatch(mower -> mower.getX() == x
                && mower.getY() == y);
    }

    public void addObstacle(int x, int y) {
        if (plateau.isInside(x, y)) {
            obstacles.add(new Obstacle(x, y));
        } else {
            throw new IllegalArgumentException("Obstacle position out of bounds");
        }
    }

    public void addMower(Mower mower) {
        mowers.add(mower);
    }

    public void updateMowerPosition(Mower mower, int newX, int newY) {
        mowers.remove(mower);
        mower.setPosition(newX, newY);
        mowers.add(mower);
    }

}

