Feature: Mower operations on a plateau

  Scenario: Mower turns left and moves forward
    Given a plateau of size 5 5
    And a mower is placed at position 1 2 N
    When the mower receives the instruction "LMLMLMLMM"
    Then the final position should be 1 3 N

  Scenario: Multiple mowers on the same plateau
    Given a plateau of size 5 5
    And a mower is placed at position 1 2 N
    And another mower is placed at position 3 3 E
    When the first mower receives the instruction "LMLMLMLMM"
    And the second mower receives the instruction "MMRMMRMRRM"
    Then the final position of the first mower should be 1 3 N
    And the final position of the second mower should be 5 1 E

  Scenario: Mower reaches the edge of the plateau
    Given a plateau of size 5 5
    And a mower is placed at position 1 2 N
    When the mower receives the instruction "MMMMM"
    Then the final position should be 1 5 N

  Scenario: Mower receives an invalid instruction
    Given a plateau of size 5 5
    And a mower is placed at position 1 2 N
    When the mower receives the instruction "LMLXZMLMM"
    Then an error should be raised with message "Invalid instruction: X"

  Scenario: Mower is placed with an invalid direction
    Given a plateau of size 5 5
    When a mower is placed at position 1 2 with invalid direction Q
    Then an error should be raised with message "Invalid direction: Q. Valid directions are N, E, S, W."

  Scenario: Mower stops when encountering another mower
    Given a plateau of size 5 5
    And a mower is placed at position 1 2 N
    And another mower is placed at position 1 3 N
    When the first mower receives the instruction "M"
    Then the final position of the first mower should be 1 2 N
    And the final position of the second mower should be 1 3 N

