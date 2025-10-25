package racingcar.service;

import racingcar.dto.CarStatus;
import racingcar.dto.FinalResult;
import racingcar.dto.RoundResult;
import racingcar.model.Car;
import racingcar.model.Cars;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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

    public FinalResult play() {
        List<RoundResult> roundResults = new ArrayList<>();

        for (int i = 0; i < round; i++) {
            RoundResult roundResult = playOneRound();
            roundResults.add(roundResult);
        }
        List<String> winnerNames = cars.getWinnerNames();

        return new FinalResult(roundResults, winnerNames);
    }

    private RoundResult playOneRound() {
        List<CarStatus> carStatuses = new ArrayList<>();

        for(Car car : this.cars.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.increaseMoveCount();
            }
            carStatuses.add(new CarStatus(car.getName(), car.getMoveCount()));
        }
        return new RoundResult(carStatuses);
    }
}
