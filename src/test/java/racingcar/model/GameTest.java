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
}
