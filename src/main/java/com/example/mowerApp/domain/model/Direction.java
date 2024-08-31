package com.example.mowerApp.domain.model;

public enum Direction {
    N("North"), E("East"), S("South"), W("West");

    private final String fullName;

    Direction(String fullName) {
        this.fullName = fullName;
    }

    public Direction turnLeft() {
        switch (this) {
            case N: return W;
            case W: return S;
            case S: return E;
            case E: return N;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public Direction turnRight() {
        switch (this) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
            default: throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    @Override
    public String toString() {
        return this.name();
    }
}

