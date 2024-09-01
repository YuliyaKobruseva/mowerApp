package com.example.mowerApp.unit.domain.model;

import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import com.example.mowerApp.domain.model.enums.Instruction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class MowerUnitTest {

    private Mower mower;
    private Plateau plateau;
    private ObstacleManager obstacleManager;

    @Before
    public void setUp() {
        plateau = Plateau.getInstance(5, 5);
        obstacleManager = Mockito.mock(ObstacleManager.class);
        mower = new Mower(1, 2, Direction.N);
    }

    @Test
    public void givenMower_whenInitialized_thenHasCorrectInitialPositionAndDirection() {
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test
    public void givenMower_whenTurnLeft_thenDirectionIsWest() {
        mower.executeInstruction(Instruction.L, plateau, obstacleManager);
        assertEquals(Direction.W, mower.getDirection());
        assertEquals("Position: (1, 2), Direction: W", mower.getMovementLog().get(1));
    }

    @Test
    public void givenMower_whenTurnRight_thenDirectionIsEast() {
        mower.executeInstruction(Instruction.R, plateau, obstacleManager);
        assertEquals(Direction.E, mower.getDirection());
        assertEquals("Position: (1, 2), Direction: E", mower.getMovementLog().get(1));
    }

    @Test
    public void givenMower_whenMoveForwardWithNoObstacle_thenPositionIsUpdated() {
        mower.executeInstruction(Instruction.M, plateau, obstacleManager);
        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals(Direction.N, mower.getDirection());
        assertEquals("Position: (1, 3), Direction: N", mower.getMovementLog().get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenMower_whenReceiveInvalidInstruction_thenThrowException() {
        mower.executeInstruction(Instruction.valueOf("Z"), plateau, obstacleManager);
    }
}
