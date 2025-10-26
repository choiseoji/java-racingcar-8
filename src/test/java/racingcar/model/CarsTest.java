package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("정상적인 입력 문자열로 Cars를 생성할 수 있다")
    void givenValidInput_thenCreateCarsSuccessfully() {
        // given
        String input = "Sally,Jinah,Anne";

        // when
        Cars cars = Cars.from(input);

        // then
        List<Car> carList = cars.getCars();
        assertThat(carList).hasSize(3);
        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("Sally", "Jinah", "Anne");
    }

    @Test
    @DisplayName("입력이 비어있으면 예외가 발생한다")
    void givenEmptyInput_thenThrowException() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> Cars.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
