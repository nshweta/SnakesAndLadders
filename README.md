# SnakesAndLadders
Snakes and Ladder game for
- Board size of 100
- Single player
- Single Snake (Solution supports adding multiple snakes)
- 2 types of Dice - Normal Dice (Rolls to a random number between 1 to 6) and Crooked Dice(Rolls to only even numbers on Dice - 2, 4, 6)

This solution is derived from TDD programming practice. 

GameBoard - This class related to the Snakes and Ladder board. This contains board size and snakes on it. It contains inner class Snake as Snake only holds value with respect to game board
Snake class is within GameBoard class in order to keep data and logic together

Game - This class contains attributes needed to play game , that is a board, player, dice. Game can be played upto required number of turns

Player - This class contains attributes/methods specific to player

Dice - This interface has a roll method. Any implementing class needs to override roll to specify it own behaviour.

Note: System outs are added to show the game progress
Game can be started from the tests - startGameWithSinglePlayerNormalDice and startGameWithSinglePlayerCrookedDice of test class SnakesAndLaddersTest
Rest tests are self explaining
