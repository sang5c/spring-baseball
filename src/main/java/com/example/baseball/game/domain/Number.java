package com.example.baseball.game.domain;

import java.util.Objects;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String OUT_OF_RANGE_STR = "range should be 1-9, input: [%d]";

    private final int number;
    private final int position;

    private Number(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Number of(String str, int position) {
        int number = Integer.parseInt(str);
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(OUT_OF_RANGE_STR, number));
        }
        return new Number(number, position);
    }

    public Judgment compare(Number target) {
        if (this.equals(target)) {
            return Judgment.STRIKE;
        }
        if (this.number == target.number) {
            return Judgment.BALL;
        }
        return Judgment.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number && position == number1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

}
