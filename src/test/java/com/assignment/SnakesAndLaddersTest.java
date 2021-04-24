package com.assignment;

import com.assignment.dice.CrookedDice;
import com.assignment.dice.Dice;
import com.assignment.dice.NormalDice;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesAndLaddersTest {
    GameBoard gameBoard;
    Player player;
    Dice dice;
    Game game;

    @Test
    public void gameBoardOfSize100(){
        createSimpleBoard(100).verifyBoardSize(100);
    }

    @Test
    public void playerWithInitialPositionZero(){
        createPlayer("Shweta").verifyPosition(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void gameBoardWithInvalidSnakePosition(){
        createBoardWithASnake(100, 10, 20);
    }

    @Test
    public void newPositionChangesWhenCaughtByASnake(){
        int currentPositionOnBoard = 14;
        int snakeStartPosition = 14;
        int snakeEndPosition = 7;
        int boardSize = 100;
        int newPositionOnBoard = createBoardWithASnake(boardSize, snakeStartPosition, snakeEndPosition).getNewPositionOnBoard(currentPositionOnBoard);
        assertEquals(snakeEndPosition, newPositionOnBoard);
    }

    @Test
    public void newPositionRemainsSameWhenNotCaughtByASnake(){
        int currentPositionOnBoard = 15;
        int snakeStartPosition = 14;
        int snakeEndPosition = 7;
        int boardSize = 100;
        int newPositionOnBoard = createBoardWithASnake(boardSize, snakeStartPosition, snakeEndPosition).getNewPositionOnBoard(currentPositionOnBoard);
        assertEquals(currentPositionOnBoard, newPositionOnBoard);
    }


    @Test
    public void startGameWithSinglePlayerNormalDice(){
        createBoardWithASnake(100, 14, 7).initializeGameWithNormalDice().playGame(10).verifyPlayerPositionNotZero();
    }

    @Test
    public void startGameWithSinglePlayerCrookedDice(){
        createBoardWithASnake(100, 14, 7).initializeGameWithCrookedDice().playGame(10).verifyPlayerPositionNotZero();
    }

    private void verifyBoardSize(int expectedBoardSize) {
        assertEquals(expectedBoardSize, gameBoard.getSize());
    }

    private SnakesAndLaddersTest createSimpleBoard(int size) {
        gameBoard = new GameBoard(100);
        return this;
    }

    private int getNewPositionOnBoard(int currentPositionOnBoard) {
        return gameBoard.getNewPosition(currentPositionOnBoard);
    }

    private SnakesAndLaddersTest createBoardWithASnake(int boardSize, int snakeStartPosition, int snakeEndPosition) {
        gameBoard = new GameBoard(boardSize);
        gameBoard.addSnake(snakeStartPosition, snakeEndPosition);
        return this;
    }

    private void verifyPlayerPositionNotZero() {
        assertNotEquals(0, player.getPosition());
    }

    private SnakesAndLaddersTest playGame(int turns) {
        game.play(turns);
        return this;
    }

    private SnakesAndLaddersTest initializeGameWithNormalDice() {
        createBoardWithASnake(100, 14, 7).createPlayer("Shweta").createNormalDice();
        game = new Game(gameBoard, player, dice);
        return this;
    }

    private SnakesAndLaddersTest initializeGameWithCrookedDice() {
        createBoardWithASnake(100, 14, 7).createPlayer("Shweta").createCrookedDice();
        game = new Game(gameBoard, player, dice);
        return this;
    }

    private void createCrookedDice() {
        dice = new CrookedDice();
    }

    private void createNormalDice() {
        dice = new NormalDice();
    }



    private SnakesAndLaddersTest verifyPosition(int expectedPosition) {
        assertEquals(expectedPosition, player.getPosition());
        return this;
    }

    private SnakesAndLaddersTest createPlayer(String playerName) {
        player = new Player(playerName);
        return this;
    }
}
