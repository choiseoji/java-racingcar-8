package racingcar.controller;

import racingcar.dto.FinalResult;
import racingcar.model.Cars;
import racingcar.model.Game;
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
        Game game = new Game(Integer.parseInt(round), cars);
        FinalResult finalResult = game.play();

        output.printGameResult(finalResult);
    }
}
