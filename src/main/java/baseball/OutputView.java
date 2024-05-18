package baseball;

public class OutputView {
    public void startGame() {
        System.out.println("야구 게임을 시작합니다! 1 ~ 9 숫자를 중복없이 사용하여 세자리 숫자를 입력해주세요.");
    }

    public void printResult(String gameNumber) {
        // String winner = whoIsWinner(gamersTurn);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

//    private String whoIsWinner(boolean gamersTurn) {
//        if(!gamersTurn) {
//            return "컴퓨터";
//        }
//        return "사용자";
//    }

    public void printRoundResult(RoundResult roundResult) {
        if(roundResult.getStrike() == 0 && roundResult.getBall() == 0) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder temp = new StringBuilder();
        if(roundResult.getBall() != 0) {
            temp.append(roundResult.getBall()).append(" 볼 ");
        }
        if(roundResult.getStrike() != 0) {
            temp.append(roundResult.getStrike()).append(" 스트라이크");
        }

        System.out.println(temp);
    }
}
