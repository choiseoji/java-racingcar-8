package racingcar.dto;

public class CarStatus {
    private String name;
    private Integer moveCount;

    public CarStatus(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public String getName() {
        return this.name;
    }

    public Integer getMoveCount() {
        return this.moveCount;
    }
}
