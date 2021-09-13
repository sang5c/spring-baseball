package com.example.baseball.game.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Count {
    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private static final String COUNT_RANGE_EXCEPTION_STR = "strike, ball range %d-%d, input: [%d]";
    private static final Map<Integer, Count> cache = new HashMap<>();

    static {
        for (int i = MIN_COUNT; i <= MAX_COUNT; i++) {
            cache.put(i, new Count(i));
        }
    }

    private final int count;

    private Count(int count) {
        validateRange(count);
        this.count = count;
    }

    public static Count of(int count) {
        validateRange(count);
        return cache.get(count);
    }

    private static void validateRange(int count) {
        if (count < MIN_COUNT || count > MAX_COUNT) {
            throw new IllegalArgumentException(String.format(COUNT_RANGE_EXCEPTION_STR, MIN_COUNT, MAX_COUNT, count));
        }
    }

    public Count increase() {
        return of(this.count + 1);
    }

    public int getCount() {
        return this.count;
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
