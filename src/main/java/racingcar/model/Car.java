package racingcar.model;

public class Car {

    private final String name;
    private Integer moveCount;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, Integer moveCount) {
        validateName(name);
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
