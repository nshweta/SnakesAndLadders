package com.assignment;

import com.assignment.dice.CrookedDice;
import com.assignment.dice.NormalDice;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void normalDiceRollsBetweenOneAndSix(){
        int rolledNumber = new NormalDice().roll();
        assertTrue(rolledNumber >= 1 && rolledNumber <= 6);
    }

    @Test
    public void crookedDiceRollsEvenNumbersOnly(){
        int rolledNumber = new CrookedDice().roll();
        assertTrue(Arrays.asList(2, 4, 6).contains(rolledNumber));
    }
}
