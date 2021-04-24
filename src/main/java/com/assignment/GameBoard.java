package com.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GameBoard {
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
        return snakeAtCurrentPosition.isPresent() ? snakeAtCurrentPosition.get().endPosition : currentPosition;
    }

    public static class Snake {
        int startPosition;
        int endPosition;
        public Snake(int startPosition,  int endPosition) {
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }
    }
}
