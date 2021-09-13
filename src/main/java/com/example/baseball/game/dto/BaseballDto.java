package com.example.baseball.game.dto;

import com.example.baseball.game.domain.Baseball;
import com.example.baseball.game.domain.Numbers;
import com.example.baseball.game.domain.Score;

public class BaseballDto {
    private Baseball baseball;
    private Numbers numbers;
    private Score score;

    public BaseballDto(Baseball baseball, Numbers numbers) {
        this.baseball = baseball;
        this.numbers = numbers;
        this.score = Score.zero();
    }

    public Baseball getBaseball() {
        return baseball;
    }

    public void setBaseball(Baseball baseball) {
        this.baseball = baseball;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public void setNumbers(Numbers numbers) {
        this.numbers = numbers;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

}
