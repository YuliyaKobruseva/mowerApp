package com.example.mowerApp.unit.domain.model;

import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ObstacleManagerUnitTest {

    private Plateau plateau;
    private ObstacleManager obstacleManager;
    private Mower mower;

    @Before
    public void setUp() {
        plateau = Plateau.getInstance(5, 5);
        obstacleManager = new ObstacleManager(plateau);
        mower = new Mower(2, 2, Direction.N);
        obstacleManager.addMower(mower);
    }

    @Test
    public void givenMowerPosition_whenCheckForObstacle_thenReturnsTrue() {
        boolean hasObstacle = obstacleManager.hasObstacle(2, 2);
        assertTrue(hasObstacle);  // Debe devolver true porque el cortacésped está en (2, 2)
    }

    @Test
    public void givenMower_whenUpdateMowerPosition_thenMovementIsSuccessful() {
        // Mueve el cortacésped a una nueva posición
        obstacleManager.updateMowerPosition(mower, 3, 3);

        // Verifica que el cortacésped ya no esté en la posición original
        assertFalse(obstacleManager.hasObstacle(2, 2));

        // Verifica que el cortacésped esté en la nueva posición
        assertTrue(obstacleManager.hasObstacle(3, 3));
    }
}
