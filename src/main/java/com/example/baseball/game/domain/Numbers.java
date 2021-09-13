package com.example.baseball.game.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String NUMBER_SPLIT_REGEX = "";
    private static final String INVALID_LENGTH_STR = "length should be 3, input: [%d]";
    public static final int NUMBERS_LENGTH = 3;

    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        if (invalidLength(numbers)) {
            throw new IllegalArgumentException(String.format(INVALID_LENGTH_STR, numbers.size()));
        }
        this.numbers = numbers;
    }

    private static boolean invalidLength(List<Number> numbers) {
        return numbers.size() != NUMBERS_LENGTH;
    }

    public static Numbers ofString(String str) {
        List<Number> numbers = convertToNumbers(str);
        return of(numbers);
    }

    public static Numbers of(List<Number> numbers) {
        return new Numbers(numbers);
    }

    private static List<Number> convertToNumbers(String str) {
        List<Number> numbers = new ArrayList<>();
        String[] split = str.split(NUMBER_SPLIT_REGEX);
        for (int i = 0; i < split.length; i++) {
            numbers.add(Number.ofString(split[i], i));
        }
        return Collections.unmodifiableList(numbers);
    }

    public Score compare(String str) {
        Numbers target = ofString(str);
        Score score = Score.zero();
        for (Number source : this.numbers) {
            for (Number number : target.numbers) {
                score = score.increaseCount(source.compare(number));
            }
        }
        return score;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::toString)
                .collect(Collectors.joining());
    }

}
