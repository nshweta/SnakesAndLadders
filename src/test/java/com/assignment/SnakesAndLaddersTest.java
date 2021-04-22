package com.assignment;

import org.junit.Assert;
import org.junit.Test;

public class SnakesAndLaddersTest {

    @Test
    public void gameBoardOfNumber100(){
        GameBoard gameBoard = new GameBoard(100);
        Assert.assertEquals(100, gameBoard.getSize());
    }
}
