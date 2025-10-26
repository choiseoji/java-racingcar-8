package racingcar.view;

import racingcar.dto.CarStatus;
import racingcar.dto.FinalResult;
import racingcar.dto.RoundResult;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private void printResultHeader() {
        System.out.println("\n실행 결과");
    }

    private void printOneRoundResult(RoundResult roundResult) {
        for(CarStatus carStatus : roundResult.carStatuses()) {
            System.out.print(carStatus.name() + " : ");
            for(int i = 0; i < carStatus.moveCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void printRoundResult(List<RoundResult> roundResults) {
        for(RoundResult roundResult : roundResults) {
            printOneRoundResult(roundResult);
            System.out.println();
        }
    }

    private void printWinners(List<String> winners) {
        String result = winners
                .stream()
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }

    public void printGameResult(FinalResult finalResult) {

        printResultHeader();
        printRoundResult(finalResult.roundResults());
        printWinners(finalResult.winners());
    }
}
