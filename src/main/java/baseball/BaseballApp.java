package baseball;

public class BaseballApp {
    public static void main(String[] args) {
        BaseballPlayground bp = new BaseballPlayground();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        do {
            String gameNumber = doGame(bp, inputView, outputView);
            outputView.printResult(bp.yourTurn(), gameNumber);  // 누가 이겼는지, 생성 숫자는 무엇이었는지.
        } while (inputView.doItAgain());

    }

    private static String doGame(BaseballPlayground bp, InputView inputView, OutputView outputView) {
        String input = "";
        do {
            input = callProperInputProcess(bp, inputView);
            RoundResult roundResult = bp.doRound(input);
            outputView.printRoundReuslt(roundResult);
        } while (bp.notOver());
        return input;
    }

    public static String callProperInputProcess(BaseballPlayground bp, InputView inputView) {
        if(bp.yourTurn()) {
            return inputView.takeInput();
        }
        return BaseballPlayground.makeRndNumber();
    }
}
