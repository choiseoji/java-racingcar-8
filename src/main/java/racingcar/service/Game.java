package racingcar.service;

import racingcar.model.Cars;

public class Game {

    private Integer round;
    private Cars cars;

    public Game(Integer round, Cars cars) {
        validateRound(round);
        this.round = round;
        this.cars = cars;
    }

    private void validateRound(Integer round) {
        if (round <= 0) {
            throw new IllegalArgumentException("라운드 수는 1 이상이어야 합니다.");
        }
    }
}
