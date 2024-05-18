package baseball;

public class BaseballApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        do {
            BaseballPlayground bp = new BaseballPlayground();
            String gameNumber = doGame(bp, inputView, outputView);
            outputView.printResult(bp.yourTurn(), gameNumber);  // 누가 이겼는지, 생성 숫자는 무엇이었는지.
        } while (!inputView.endThisGame());
    }

    private static String doGame(BaseballPlayground bp, InputView inputView, OutputView outputView) {
        String input;
        do {
            input = callProperInputProcess(bp, inputView);  // 반드시 리턴 값이 숫자 3 자리인 String이어야 한다.
            RoundResult roundResult = bp.doRound(input);
            outputView.printRoundReuslt(roundResult);
        } while (bp.notOver());
        return input;
    }

    private static String callProperInputProcess(BaseballPlayground bp, InputView inputView) {
        if(bp.yourTurn()) {
            return inputView.takeInput();
        }
        return BaseballPlayground.makeRndNumber();
    }
}
