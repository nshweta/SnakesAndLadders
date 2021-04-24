package com.assignment;

import com.assignment.dice.Dice;

public class Player {
    private String name;
    private int position = 0;

    public Player(String playerName) {
        this.name = playerName;
    }


    public boolean isWinner(int size) {
        return position == size;
    }

    public void plays(Dice dice) {
        position += dice.roll();
    }

    public int getPosition() {
        return position;
    }


    public void setPosition(int newPosition) {
        position = newPosition;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
