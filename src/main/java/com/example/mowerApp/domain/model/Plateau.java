package com.example.mowerApp.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Plateau {
    private int width;
    private int height;

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}

