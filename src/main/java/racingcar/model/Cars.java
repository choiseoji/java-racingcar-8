package racingcar.model;


import java.util.Arrays;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public static Cars from(String input) {
        validateInput(input);

        String[] names = input.split(",");
        List<Car> cars = Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .toList();

        validateDuplicate(cars);
        return new Cars(cars);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private static void validateDuplicate(List<Car> cars) {
        long uniqueCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (uniqueCount != cars.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    public void moveOneCar(int index) {

        Car car = this.cars.get(index);
        car.increaseMoveCount();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }
}
