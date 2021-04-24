package com.assignment.dice;

import java.util.Random;

public interface Dice {
    int roll();

    default int printAndReturnDiceNumber(int number){
        System.out.println("Dice rolled to number "+ number);
        return number;
    }
}
