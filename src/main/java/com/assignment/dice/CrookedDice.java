package com.assignment.dice;

import java.util.Random;

public class CrookedDice implements Dice {
    @Override
    public int roll() {
        return printAndReturnDiceNumber((new Random().nextInt(3) + 1) * 2);
    }
}
