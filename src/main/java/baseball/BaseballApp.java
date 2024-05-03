package baseball;

public class BaseballApp {
    public static void main(String[] args) {
        BaseballPlayground bp = new BaseballPlayground();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        do {
            String input;
            if(bp.yourTurn()) {
                input = inputView.takeInput();
            } else {
                input = BaseballPlayground.makeRndNumber();
            }
            RoundResult roundResult = bp.doGame(input);
            outputView.printResult(roundResult);
        } while (bp.notOver());
    }
}
