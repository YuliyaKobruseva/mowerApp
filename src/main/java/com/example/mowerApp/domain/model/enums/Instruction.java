package com.example.mowerApp.domain.model.enums;

public enum Instruction {
    L, R, M;

    public static Instruction fromChar(char input) {
        switch (input) {
            case 'L': return L;
            case 'R': return R;
            case 'M': return M;
            default: throw new IllegalArgumentException("Invalid instruction: " + input);
        }
    }
}

