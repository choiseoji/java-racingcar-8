package racingcar.dto;

import java.util.List;

public record FinalResult(
        List<RoundResult> roundResults,
        List<String> winners
) {
}
