package racingcar.dto;

import java.util.List;

public class RoundResult {
    List<CarStatus> carStatuses;

    public RoundResult(List<CarStatus> cars) {
        this.carStatuses = List.copyOf(cars);
    }

    public List<CarStatus> getCarStatuses() {
        return this.carStatuses;
    }
}
