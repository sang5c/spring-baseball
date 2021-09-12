package com.example.baseball.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumberTest {

    @DisplayName("문자와 위치를 받아 객체를 생성한다.")
    @Test
    void ofString() {
        Number number = Number.of("1", 0);
        assertThat(number).isNotNull();
    }

    @DisplayName("1-9 숫자가 아니면 Exception이 발생한다.")
    @Test
    void invalidNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of("0", 0));
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of("#", 0));
        assertThatIllegalArgumentException().isThrownBy(() -> Number.of("10", 0));
    }

    @DisplayName("생성시 숫자와 포지션이 같다면 같은 객체를 반환한다.")
    @Test
    void equalsAndHashcode() {
        assertThat(Number.of("1", 0)).isEqualTo(Number.of("1", 0));
    }

    @DisplayName("생성시 숫자나 포지션이 다르면 다른 객체를 반환한다.")
    @Test
    void notEqualsDiffValueOrDiffPosition() {
        assertThat(Number.of("1", 0)).isNotEqualTo(Number.of("1", 1));
        assertThat(Number.of("1", 0)).isNotEqualTo(Number.of("2", 0));
    }

    @DisplayName("비교시 숫자와 포지션이 같으면 STRIKE를 반환한다.")
    @Test
    void compareReturnStrike() {
        Number number = Number.of("1", 0);
        assertThat(number.compare(Number.of("1", 0))).isEqualTo(Judgment.STRIKE);
    }

    @DisplayName("비교시 숫자가 같고 포지션이 다르면 BALL을 반환한다.")
    @Test
    void compareReturnBall() {
        Number number = Number.of("1", 0);
        assertThat(number.compare(Number.of("1", 1))).isEqualTo(Judgment.BALL);
    }

    @DisplayName("비교시 숫자와 포지션이 다르면 NOTHING을 반환한다.")
    @Test
    void compareReturnNothing() {
        Number number = Number.of("1", 0);
        assertThat(number.compare(Number.of("2", 1))).isEqualTo(Judgment.NOTHING);
    }

}
