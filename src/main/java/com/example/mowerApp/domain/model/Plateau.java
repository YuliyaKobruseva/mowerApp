package com.example.mowerApp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

public class Plateau {
    private int width;
    private int height;

    private static Plateau instance;

    private Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static synchronized Plateau getInstance(int width, int height) {
        if (instance == null) {
            instance = new Plateau(width, height);
        }
        return instance;
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}

