package racingcar.model;

public class Car {

    private String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }

    public void increaseMoveCount() {
        this.moveCount++;
    }
}
