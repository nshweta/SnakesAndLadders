package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameBoard {
    public static final String INVALID_SNAKE_POSITIONS = "Snake's end position cannot be greater start position";
    public static final String CAUGHT_BY_SNAKE = "Caught by Snake at position: %d, new position: %d";
    private int size;
    private List<Snake> snakes;

    public GameBoard(int size) {
        this.size = size;
        this.snakes = new ArrayList<Snake>();
    }

    public int getSize() {
        return size;
    }

    public void addSnake(int startPosition, int endPosition ) {
        snakes.add(new Snake(startPosition, endPosition));
    }

    public int getNewPosition(final int currentPosition) {
        Optional<Snake> snakeAtCurrentPosition = snakes.stream().filter(snake -> snake.startPosition == currentPosition).findFirst();
        if(snakeAtCurrentPosition.isPresent()){
            System.out.println(String.format(CAUGHT_BY_SNAKE, currentPosition, snakeAtCurrentPosition.get().endPosition));
            return snakeAtCurrentPosition.get().endPosition;
        }
        return currentPosition;
    }

    public static class Snake {
        int startPosition;
        int endPosition;
        public Snake(int startPosition,  int endPosition) {
            if(endPosition > startPosition){
                throw new IllegalArgumentException(INVALID_SNAKE_POSITIONS);
            }
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }
    }
}
