package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int MOVE_THRESHOLD = 4;
    private final Integer round;
    private final Cars cars;
    private List<List<Car>> roundHistory = new ArrayList<>();

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

    public void play() {
        for (int i = 0; i < round; i++) {
            playOneRound();
            roundHistory.add(createSnapshot(cars));
        }
    }

    private void playOneRound() {
        int numberOfCars = cars.getNumberOfCars();
        for(int index = 0; index < numberOfCars; index++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= MOVE_THRESHOLD) {
                cars.moveOneCar(index);
            }
        }
    }

    private List<Car> createSnapshot(Cars cars) {
        return cars
                .getCars()
                .stream()
                .map(car -> new Car(car.getName(), car.getMoveCount()))
                .collect(Collectors.toList());
    }

    public List<List<Car>> getRoundHistory() {
        return this.roundHistory;
    }

    public List<String> getWinners() {
        int maxMoveCount = cars.getCars()
                .stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(() -> new IllegalStateException("우승자가 없습니다."));

        return cars.getCars()
                .stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }
}
