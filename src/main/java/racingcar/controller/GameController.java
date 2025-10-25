package racingcar.controller;

import racingcar.dto.FinalResult;
import racingcar.model.Cars;
import racingcar.service.GameService;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private Input input;
    private Output output;

    public GameController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        String names = input.readCarNames();
        String round = input.readNumberOfRounds();

        Cars cars = Cars.from(names);
        GameService gameService = new GameService(Integer.parseInt(round), cars);
        FinalResult finalResult = gameService.play();

        output.printGameResult(finalResult);
    }
}
