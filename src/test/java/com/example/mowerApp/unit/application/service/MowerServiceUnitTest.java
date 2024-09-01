package com.example.mowerApp.unit.application.service;

import com.example.mowerApp.application.service.MowerService;
import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MowerServiceUnitTest {

    private MowerService mowerService;
    private Plateau plateau;
    private ObstacleManager obstacleManager;
    private Mower mower;

    @Before
    public void setUp() {
        plateau = Plateau.getInstance(5, 5);
        mowerService = new MowerService(plateau);
        obstacleManager = Mockito.mock(ObstacleManager.class);
        mower = new Mower(1, 2, Direction.N);
    }

    @Test
    public void givenValidInstructions_whenMoveMower_thenPositionAndDirectionAreUpdated() {
        String instructions = "LMLMLMLMM";
        mowerService.moveMower(mower, instructions, plateau, obstacleManager);

        // Verifica la posición final y la dirección
        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals(Direction.N, mower.getDirection());
    }

    @Test(expected = InvalidInstructionException.class)
    public void givenInvalidInstruction_whenMoveMower_thenThrowInvalidInstructionException() {
        String instructions = "LMLMLXLM"; // 'X' no es una instrucción válida

        mowerService.moveMower(mower, instructions, plateau, obstacleManager);
    }
}

