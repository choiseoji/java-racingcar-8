package racingcar.controller;

import racingcar.dto.FinalResult;
import racingcar.mapper.ResultMapper;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private final Input input;
    private final Output output;
    private final ResultMapper resultMapper;

    public GameController(Input input, Output output, ResultMapper resultMapper) {
        this.input = input;
        this.output = output;
        this.resultMapper = resultMapper;
    }

    public void run() {
        String names = input.readCarNames();
        String round = input.readNumberOfRounds();

        Cars cars = Cars.from(names);
        Game game = new Game(Integer.parseInt(round), cars);
        game.play();

        FinalResult finalResult = resultMapper.toFinalResult(
                game.getRoundHistory(),
                game.getWinners()
        );
        output.printGameResult(finalResult);
    }
}
