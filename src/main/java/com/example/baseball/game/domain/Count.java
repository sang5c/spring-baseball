package com.example.baseball.game.domain;

import java.util.Objects;

public class Count {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static final String COUNT_RANGE_EXCEPTION_STR = "strike, ball range %d-%d, input: [%d]";

    private final int count;

    public Count(int count) {
        validateRange(count);
        this.count = count;
    }

    private void validateRange(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(String.format(COUNT_RANGE_EXCEPTION_STR, MIN_COUNT, MAX_COUNT, count));
        }
    }

    public Count increase() {
        return new Count(this.count + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

}
