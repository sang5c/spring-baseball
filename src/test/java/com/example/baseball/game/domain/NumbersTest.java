package com.example.baseball.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumbersTest {

    @DisplayName("숫자 세개로된 문자열을 받아 객체를 반환")
    @Test
    void create() {
        Numbers numbers = Numbers.ofString("123");
        assertThat(numbers).isNotNull();
    }

    @DisplayName("길이가 3이 아니면 Exception")
    @Test
    void invalidLengthThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.ofString("1234"));
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.ofString("12"));
    }

    @DisplayName("숫자, 범위는 1~9")
    @Test
    void invalidNumber() {
        assertIllegalArgumentException("023");
        assertIllegalArgumentException("12#");
        assertIllegalArgumentException("1A3");
    }

    private void assertIllegalArgumentException(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.ofString(str));
    }

    @DisplayName("숫자가 일치하지 않으면 nothing")
    @Test
    void nothing() {
        sameScore("456", 0, 0);
    }

    @DisplayName("숫자와 자리가 일치하면 strike")
    @Test
    void sameNumberAndSamePositionIsStrike() {
        sameScore("123", 3, 0);
        sameScore("143", 2, 0);
        sameScore("425", 1, 0);
    }

    @DisplayName("숫자가 일치하고 자리가 일치하지 않으면 ball")
    @Test
    void sameNumberAndDiffPositionIsBall() {
        sameScore("312", 0, 3);
        sameScore("241", 0, 2);
        sameScore("435", 0, 1);
    }

    private void sameScore(String target, int strike, int ball) {
        Numbers numbers = Numbers.ofString("123");
        assertThat(numbers.compare(target)).isEqualTo(Score.of(strike, ball));
    }
}
