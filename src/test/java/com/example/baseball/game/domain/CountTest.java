package com.example.baseball.game.domain;

import com.example.baseball.game.domain.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountTest {

    @DisplayName("숫자를 받아 객체를 생성한다")
    @Test
    void createCount() {
        Count count = new Count(0);
        assertThat(count).isNotNull();
    }

    @DisplayName("0-3 범위가 아니면 Exception이 발생한다.")
    @Test
    void invalidCountThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Count(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Count(4));
    }

}
