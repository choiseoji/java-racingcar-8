package racingcar.mapper;

import racingcar.dto.CarStatus;
import racingcar.dto.FinalResult;
import racingcar.dto.RoundResult;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultMapper {

    public static FinalResult toFinalResult(List<List<Car>> roundData, List<String> winners) {

        List<RoundResult> roundResults = new ArrayList<>();
        for(List<Car> cars : roundData) {
            roundResults.add(toRoundResult(cars));
        }
        return new FinalResult(roundResults, winners);
    }

    public static RoundResult toRoundResult(List<Car> cars) {

        List<CarStatus> carStatuses = new ArrayList<>();
        for(Car car : cars) {
            carStatuses.add(new CarStatus(car.getName(), car.getMoveCount()));
        }
        return new RoundResult(carStatuses);
    }
}
