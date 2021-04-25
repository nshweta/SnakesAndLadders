package com.assignment;

import com.assignment.dice.Dice;

public class Player {
    private String name;
    private int position = 0;
    private boolean isWinner;

    public Player(String playerName) {
        this.name = playerName;
    }


    public boolean isWinner() {
        return isWinner;
    }

    public void plays(Dice dice, int size) {
        int newPosition = position + dice.roll();
        position = newPosition > size ? position : newPosition;
        isWinner = position == size;
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
