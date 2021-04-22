package com.assignment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SnakesAndLaddersTest {
    Player player;
    @Test
    public void gameBoardOfSize100(){
        GameBoard gameBoard = new GameBoard(100);
        assertEquals(100, gameBoard.getSize());
    }

    @Test
    public void playerWithInitialPositionToZero(){
        createPlayer().verifyPosition(0);
    }

    private SnakesAndLaddersTest verifyPosition(int expectedScore) {
        assertEquals(expectedScore, player.getCurrentPosition());
        return this;
    }

    private SnakesAndLaddersTest createPlayer() {
        player = new Player();
        return this;
    }
}
