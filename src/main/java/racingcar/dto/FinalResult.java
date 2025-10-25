package racingcar.dto;

import java.util.List;

public class FinalResult {

    List<RoundResult> roundResults;
    List<String> winners;

    public FinalResult(List<RoundResult> roundResults, List<String> winners) {
        this.roundResults = List.copyOf(roundResults);
        this.winners = List.copyOf(winners);
    }

    public List<RoundResult> getRoundResults() {
        return this.roundResults;
    }

    public List<String> getWinners() {
        return this.winners;
    }
}
