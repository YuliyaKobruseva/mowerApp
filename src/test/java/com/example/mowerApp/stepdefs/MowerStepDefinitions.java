package com.example.mowerApp.stepdefs;

import com.example.mowerApp.application.service.MowerService;
import com.example.mowerApp.domain.exception.InvalidInstructionException;
import com.example.mowerApp.domain.model.Mower;
import com.example.mowerApp.domain.model.ObstacleManager;
import com.example.mowerApp.domain.model.Plateau;
import com.example.mowerApp.domain.model.enums.Direction;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class MowerStepDefinitions {

    private Plateau plateau;
    private Mower mower;
    private ObstacleManager obstacleManager;
    private List<Mower> mowers = new ArrayList<>();
    private Exception exception;

    @Before
    public void setUp() {
        // Inicializar ObstacleManager y otros componentes comunes aquí
        this.plateau = Plateau.getInstance(5, 5);  // Por ejemplo, con un tamaño por defecto
        this.obstacleManager = new ObstacleManager(plateau);
    }

    @Given("a plateau of size {int} {int}")
    public void a_plateau_of_size(int width, int height) {
        plateau = Plateau.getInstance(width, height);
    }

    @When("a mower is placed at position {int} {int} {word}")
    public void a_mower_is_placed_at_position_with_invalid_direction(int x, int y, String direction) {
        try {
            Direction dir = Direction.valueOf(direction.toUpperCase());
            mower = new Mower(x, y, dir);
            mowers.add(mower);
        } catch (IllegalArgumentException e) {
            exception = new IllegalArgumentException("Invalid direction: " + direction + ". Valid directions are N, E, S, W.");
        }
    }

    @Given("another mower is placed at position {int} {int} {word}")
    public void another_mower_is_placed_at_position_facing(int x, int y, String direction) {
        Mower anotherMower = new Mower(x, y, Direction.valueOf(direction.toUpperCase()));
        mowers.add(anotherMower);
    }

    @When("the mower receives the instruction {string}")
    public void the_mower_receives_the_instruction(String instructions) {
        try {
            MowerService mowerService = new MowerService(plateau);
            mowerService.moveMower(mower, instructions.toUpperCase(), plateau, obstacleManager);
        } catch (InvalidInstructionException e) {
            exception = e;
        }
    }

    @When("the first mower receives the instruction {string}")
    public void the_first_mower_receives_the_instruction(String instructions) {
        MowerService mowerService = new MowerService(plateau);
        mowerService.moveMower(mowers.get(0), instructions.toUpperCase(), plateau, obstacleManager);
    }

    @When("the second mower receives the instruction {string}")
    public void the_second_mower_receives_the_instruction(String instructions) {
        MowerService mowerService = new MowerService(plateau);
        mowerService.moveMower(mowers.get(1), instructions.toUpperCase(), plateau, obstacleManager);
    }

    @Then("the final position should be {int} {int} {word}")
    public void the_final_position_should_be(int finalX, int finalY, String finalDirection) {
        assertEquals(finalX, mower.getX());
        assertEquals(finalY, mower.getY());
        assertEquals(Direction.valueOf(finalDirection.toUpperCase()), mower.getDirection());
    }

    @Then("the final position of the first mower should be {int} {int} {word}")
    public void the_final_position_of_the_first_mower_should_be(int finalX, int finalY, String finalDirection) {
        Mower firstMower = mowers.get(0);
        assertEquals(finalX, firstMower.getX());
        assertEquals(finalY, firstMower.getY());
        assertEquals(Direction.valueOf(finalDirection.toUpperCase()), firstMower.getDirection());
    }

    @Then("the final position of the second mower should be {int} {int} {word}")
    public void the_final_position_of_the_second_mower_should_be(int finalX, int finalY, String finalDirection) {
        Mower secondMower = mowers.get(1);
        assertEquals(finalX, secondMower.getX());
        assertEquals(finalY, secondMower.getY());
        assertEquals(Direction.valueOf(finalDirection.toUpperCase()), secondMower.getDirection());
    }

    @Then("an error should be raised with message {string}")
    public void an_error_should_be_raised_with_message(String expectedMessage) {
        assertEquals(expectedMessage, exception.getMessage());
    }
}
