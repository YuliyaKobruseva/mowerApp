package com.example.mowerApp.unit.domain.model;

import com.example.mowerApp.domain.model.Plateau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauUnitTest {

    private Plateau plateau;

    @Before
    public void setUp() {
        plateau = Plateau.getInstance(5, 5);
    }

    @Test
    public void testIsInside() {
        // Verifica que las coordenadas dentro de los límites del plateau son reconocidas como válidas
        assertTrue(plateau.isInside(0, 0));
        assertTrue(plateau.isInside(3, 3));
        assertTrue(plateau.isInside(5, 5));

        // Verifica que las coordenadas fuera de los límites no son reconocidas como válidas
        assertFalse(plateau.isInside(-1, 0));
        assertFalse(plateau.isInside(6, 5));
        assertFalse(plateau.isInside(5, 6));
    }

    @Test
    public void testSingletonBehavior() {
        // Verifica que el plateau es un singleton (solo una instancia)
        Plateau samePlateau = Plateau.getInstance(7, 7);
        assertSame(plateau, samePlateau);

        // Verifica que las dimensiones no cambian después de intentar crear otra instancia con diferentes dimensiones
        assertEquals(5, samePlateau.getWidth());
        assertEquals(5, samePlateau.getHeight());
    }

}