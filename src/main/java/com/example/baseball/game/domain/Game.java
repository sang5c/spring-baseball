package com.example.baseball.game.domain;

public class Game {
    public static final int NUMBERS_LENGTH = 3;
    private final Numbers numbers;

    private Game(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Game create(String str) {
        return new Game(Numbers.of(str));
    }

    public Score compare(String str) {
        return numbers.compare(str);
    }

}
