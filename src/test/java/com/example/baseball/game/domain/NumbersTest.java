package com.example.baseball.game.domain;

import com.example.baseball.game.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NumbersTest {

    @DisplayName("숫자 세개로된 문자열을 받아 객체를 반환")
    @Test
    void create() {
        Numbers numbers = Numbers.of("123");
        assertThat(numbers).isNotNull();
    }

    @DisplayName("길이가 3이 아니면 Exception")
    @Test
    void invalidLengthThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.of("1234"));
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.of("12"));
    }

}
