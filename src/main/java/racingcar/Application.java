package racingcar;

import racingcar.controller.GameController;
import racingcar.mapper.ResultMapper;
import racingcar.view.Input;
import racingcar.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();
        ResultMapper resultMapper = new ResultMapper();

        GameController gameController = new GameController(input, output, resultMapper);
        gameController.run();
    }
}
