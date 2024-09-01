package com.example.mowerApp.unit.domain.model.enums;

import com.example.mowerApp.domain.model.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionUnitTest {

    @Test
    public void givenNorth_whenTurnLeft_thenDirectionIsWest() {
        assertEquals(Direction.W, Direction.N.turnLeft());
    }

    @Test
    public void givenNorth_whenTurnRight_thenDirectionIsEast() {
        assertEquals(Direction.E, Direction.N.turnRight());
    }

    @Test
    public void givenWest_whenTurnLeft_thenDirectionIsSouth() {
        assertEquals(Direction.S, Direction.W.turnLeft());
    }

    @Test
    public void givenWest_whenTurnRight_thenDirectionIsNorth() {
        assertEquals(Direction.N, Direction.W.turnRight());
    }

    @Test
    public void givenDirection_whenToString_thenReturnsName() {
        assertEquals("N", Direction.N.toString());
        assertEquals("E", Direction.E.toString());
        assertEquals("S", Direction.S.toString());
        assertEquals("W", Direction.W.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidDirection_whenTurnLeft_thenThrowsIllegalArgumentException() {
        Direction.valueOf("Q").turnLeft();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidDirection_whenTurnRight_thenThrowsIllegalArgumentException() {
        Direction.valueOf("Q").turnRight();
    }
}
