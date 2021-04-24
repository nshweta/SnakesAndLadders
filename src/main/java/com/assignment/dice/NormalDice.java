package com.assignment.dice;

import java.util.Random;

public class NormalDice implements Dice {
    @Override
    public int roll() {
        return printAndReturnDiceNumber(new Random().nextInt(6) + 1);
    }
}
