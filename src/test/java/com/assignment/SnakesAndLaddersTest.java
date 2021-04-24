package com.assignment;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesAndLaddersTest {
    GameBoard gameBoard;
    Player player;
    Dice dice;
    Game game;

    @Test
    public void gameBoardOfSize100(){
        GameBoard gameBoard = new GameBoard(100);
        assertEquals(100, gameBoard.getSize());
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

    private int getNewPositionOnBoard(int currentPositionOnBoard) {
        return gameBoard.getNewPosition(currentPositionOnBoard);
    }

    private SnakesAndLaddersTest createBoardWithASnake(int boardSize, int snakeStartPosition, int snakeEndPosition) {
        gameBoard = new GameBoard(boardSize);
        gameBoard.addSnake(snakeStartPosition, snakeEndPosition);
        return this;
    }

    @Test
    public void playerWithInitialPositionZero(){
        createPlayer("Shweta").verifyPosition(0);
    }


    @Test
    public void startGameWithSinglePlayer(){
        createBoard().initializeGame().playGame(10).verifyPlayerPositionNotZero();
    }

    private void verifyPlayerPositionNotZero() {
        assertNotEquals(0, player.getPosition());
    }

    private SnakesAndLaddersTest playGame(int turns) {
        game.play(turns);
        return this;
    }

    private SnakesAndLaddersTest initializeGame() {
        createBoard().createPlayer("Shweta").createNormalDice();
        game = new Game(gameBoard, player, dice);
        return this;
    }

    private void createNormalDice() {
        dice = new Dice();
    }


    private SnakesAndLaddersTest createBoard() {
        gameBoard = new GameBoard(100);
        gameBoard.addSnake(14, 7);
        return this;
    }

    private SnakesAndLaddersTest startGame() {
//        GameBoard board =
//        game = new Game()
        return this;
    }


    private SnakesAndLaddersTest plays() {
        player.plays(dice);
        return this;
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
