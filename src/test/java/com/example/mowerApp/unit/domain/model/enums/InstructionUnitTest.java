package com.example.mowerApp.unit.domain.model.enums;
import com.example.mowerApp.domain.model.enums.Instruction;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstructionUnitTest {

        @Test
        public void givenCharL_whenFromChar_thenReturnInstructionL() {
            assertEquals(Instruction.L, Instruction.fromChar('L'));
        }

        @Test
        public void givenCharR_whenFromChar_thenReturnInstructionR() {
            assertEquals(Instruction.R, Instruction.fromChar('R'));
        }

        @Test
        public void givenCharM_whenFromChar_thenReturnInstructionM() {
            assertEquals(Instruction.M, Instruction.fromChar('M'));
        }

        @Test(expected = IllegalArgumentException.class)
        public void givenInvalidChar_whenFromChar_thenThrowsIllegalArgumentException() {
            Instruction.fromChar('X');
        }
    }

