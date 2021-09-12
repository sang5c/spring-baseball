package com.example.baseball.game.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ScoreTest {

    @DisplayName("스트라이크와 볼을 받아 객체를 생성한다.")
    @Test
    void createScore() {
        Score score = Score.of(1, 2);
        assertThat(score).isNotNull();
    }

    @DisplayName("스트라이크와 볼이 같다면 같은 객체를 반환한다")
    @Test
    void equalsAndHashcode() {
        Score score = Score.of(1, 2);
        assertThat(score).isEqualTo(Score.of(1, 2));
    }

    @DisplayName("STRIKE를 받으면 스트라이크 카운트가 증가한다.")
    @Test
    void increaseStrikeCount() {
        Score score = Score.of(0, 1);
        score = score.increaseCount(Judgment.STRIKE);
        assertThat(score).isEqualTo(Score.of(1, 1));
    }

    @DisplayName("BALL을 받으면 볼 카운트가 증가한다.")
    @Test
    void increaseBallCount() {
        Score score = Score.of(0, 1);
        score = score.increaseCount(Judgment.BALL);
        assertThat(score).isEqualTo(Score.of(0, 2));
    }

    @DisplayName("NOTHING을 받으면 카운트가 증가하지 않는다.")
    @Test
    void notIncreaseCount() {
        Score score = Score.of(0, 1);
        score = score.increaseCount(Judgment.NOTHING);
        assertThat(score).isEqualTo(Score.of(0, 1));
    }

    @DisplayName("스트라이크는 0-3 숫자가 아니면 Exception이 발생한다.")
    @Test
    void strikeNumberRangeZeroToThree() {
        assertIllegalArgumentException(4, 0);
        assertIllegalArgumentException(-1, 0);
    }

    @DisplayName("볼은 0-3 숫자가 아니면 Exception이 발생한다.")
    @Test
    void ballNumberRangeZeroToThree() {
        assertIllegalArgumentException(0, 4);
        assertIllegalArgumentException(0, -1);
    }
    
    @DisplayName("볼과 스트라이크의 합은 최대 3이다.")
    @Test
    void sumOfBallAndStrikeUpToThree() {
        assertIllegalArgumentException(2, 2);
    }

    private void assertIllegalArgumentException(int strike, int ball) {
        assertThatIllegalArgumentException().isThrownBy(() -> Score.of(strike, ball));
    }

}
