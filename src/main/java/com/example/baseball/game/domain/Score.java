package com.example.baseball.game.domain;

import java.util.Objects;

public class Score {
    private static final String STRIKE_BALL_SUM_EXCEPTION_STR = "sum of strike and ball up to 3, input: [%d]";
    private final Count strike;
    private final Count ball;

    private Score(Count strike, Count ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Score of(int strike, int ball) {
        validateStrikeAndBall(strike, ball);
        return new Score(Count.of(strike), Count.of(ball));
    }

    public static Score zero() {
        return new Score(Count.of(0), Count.of(0));
    }

    private static void validateStrikeAndBall(int strike, int ball) {
        if (strike + ball > Numbers.NUMBERS_LENGTH) {
            throw new IllegalArgumentException(String.format(STRIKE_BALL_SUM_EXCEPTION_STR, strike + ball));
        }
    }

    public Score increaseCount(Judgment judgment) {
        if (judgment == Judgment.STRIKE) {
            return new Score(strike.increase(), ball);
        }
        if (judgment == Judgment.BALL) {
            return new Score(strike, ball.increase());
        }
        return this;
    }

    public int getStrike() {
        return strike.getCount();
    }

    public int getBall() {
        return ball.getCount();
    }

    public boolean isStrike() {
        return strike.getCount() == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return Objects.equals(strike, score.strike) && Objects.equals(ball, score.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

}
