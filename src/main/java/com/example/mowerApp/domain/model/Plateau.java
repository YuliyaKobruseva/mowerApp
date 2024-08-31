package com.example.mowerApp.domain.model;

import lombok.Getter;

@Getter
public class Plateau {
    private final int width;
    private final int height;

    private Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static class SingletonHelper {
        private static Plateau INSTANCE;

        private static Plateau createInstance(int width, int height) {
            if (INSTANCE == null) {
                INSTANCE = new Plateau(width, height);
            }
            return INSTANCE;
        }
    }

    public static Plateau getInstance(int width, int height) {
        return SingletonHelper.createInstance(width, height);
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}

