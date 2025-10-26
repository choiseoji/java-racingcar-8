package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 자동차_이름이_비어있으면_예외_발생() {
        // given
        String emptyName = "";

        // when, then
        assertThatThrownBy(() -> new Car(emptyName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_6자_이상이면_예외_발생() {
        // given
        String longName = "helloo";

        // when, then
        assertThatThrownBy(() -> new Car(longName))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
