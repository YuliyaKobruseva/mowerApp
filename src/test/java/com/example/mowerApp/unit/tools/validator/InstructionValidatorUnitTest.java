package com.example.mowerApp.unit.tools.validator;

import com.example.mowerApp.domain.model.enums.Instruction;
import com.example.mowerApp.tools.validator.InstructionValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionValidatorUnitTest {

    @Test
    public void givenValidInstructionChar_whenValidateInstruction_thenReturnsInstruction() {
        assertEquals(Instruction.L, InstructionValidator.validateInstruction('L'));
        assertEquals(Instruction.R, InstructionValidator.validateInstruction('R'));
        assertEquals(Instruction.M, InstructionValidator.validateInstruction('M'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidInstructionChar_whenValidateInstruction_thenThrowsIllegalArgumentException() {
        InstructionValidator.validateInstruction('X');
    }

    @Test
    public void givenValidInstructionsString_whenValidateInstructionsMatches_thenPassesValidation() {
        InstructionValidator.validateInstructionsMatches("LMLMRM");
        InstructionValidator.validateInstructionsMatches("RMRLRM");
        InstructionValidator.validateInstructionsMatches("MMM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidInstructionsString_whenValidateInstructionsMatches_thenThrowsIllegalArgumentException() {
        InstructionValidator.validateInstructionsMatches("LMXMRM");
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyInstructionsString_whenValidateInstructionsMatches_thenThrowsIllegalArgumentException() {
        InstructionValidator.validateInstructionsMatches("");
    }
}

