package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    @DisplayName("라운드 수가 1 이상이면 Game 객체가 정상 생성된다")
    void givenPositiveRound_thenGameIsCreated() {
        // given
        Cars cars = Cars.from("A,B,C");

        // when
        Game game = new Game(3, cars);

        // then
        assertThat(game).isNotNull();
        assertThat(game.getRoundHistory()).isEmpty();
    }

    @Test
    @DisplayName("라운드 수가 0 이하이면 예외가 발생한다")
    void givenNonPositiveRound_thenThrowsException() {
        // given
        Cars cars = Cars.from("A,B");

        // when, then
        org.junit.jupiter.api.Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Game(0, cars)
        );
    }
}
