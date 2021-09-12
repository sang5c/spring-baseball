package com.example.baseball.game.domain;

import com.example.baseball.game.domain.Game;
import com.example.baseball.game.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        this.game = Game.create("123");
    }

    @DisplayName("세자리 숫자를 받아 게임을 생성")
    @Test
    public void createGame() {
        assertThat(game).isNotNull();
    }

    @DisplayName("세자리가 아니면 에러")
    @Test
    void invalidGameLength() {
        assertIllegalArgumentException("1234");
        assertIllegalArgumentException("23");
    }

    @DisplayName("숫자, 범위는 1~9")
    @Test
    void invalidNumber() {
        assertIllegalArgumentException("023");
        assertIllegalArgumentException("12#");
        assertIllegalArgumentException("1A3");
    }

    private void assertIllegalArgumentException(String str) {
        assertThatIllegalArgumentException().isThrownBy(() -> Game.create(str));
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
        assertThat(game.compare(target)).isEqualTo(Score.of(strike, ball));
    }

}
