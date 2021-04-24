package com.assignment;

import com.assignment.dice.Dice;

public class Game {
    public static final String PLAYER_POSITION_INFO = "Player %s is at position %d in turn number %d";
    public static final String PLAYER_WINS = "Player %s wins";
    private GameBoard gameBoard;
    private Player player;
    private Dice dice;
    public Game(GameBoard gameBoard, Player player, Dice dice) {
        this.gameBoard = gameBoard;
        this.player = player;
        this.dice = dice;
    }


    public void play(int turns) {
       for(int turn=0; turn < turns ; turn++){
           player.plays(dice);
           player.setPosition(gameBoard.getNewPosition(player.getPosition()));
           System.out.println(String.format(PLAYER_POSITION_INFO, player.getName(), player.getPosition(), turn));
           if(player.isWinner(gameBoard.getSize())){
               System.out.println(String.format(PLAYER_WINS, player.getName()));
               break;
           }
       }

    }
}
