package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("자동차 이름이 비어있으면 예외가 발생한다")
    void givenBlankName_thenThrowsException() {
        // given
        String emptyName = "";

        // when, then
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 예외가 발생한다")
    void givenNameLongerThanFive_thenThrowsException() {
        // given
        String longName = "helloo";

        // when, then
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 전진하면 moveCount가 증가한다")
    void givenCar_whenIncreaseMoveCount_thenMoveCountIncreases() {
        // given
        Car car = new Car("A");

        // when
        car.increaseMoveCount();

        // then
        assertThat(car.getMoveCount()).isEqualTo(1);
    }
}
