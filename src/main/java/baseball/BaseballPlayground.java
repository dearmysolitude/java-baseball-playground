package baseball;

public class BaseballPlayground {
    private final String rndNumber;
    private Boolean isItYourTurn;
    private Boolean notOver;

    public BaseballPlayground() {
        this.rndNumber = makeRndNumber();
        this.isItYourTurn = true;
        this.notOver = true;
    }

    public BaseballPlayground(String number) {  // 테스트 코드를 위한 생성자
        this.rndNumber = number;
        this.isItYourTurn = true;
        this.notOver = true;
    }

    // 라운드 결과를 확인하는 메인 로직, 입력은 문자열로 받는다.
    public RoundResult  doRound(String input) {
        RoundResult result = makeRoundResult(input);

        if(result.getStrike() == 3) {
            this.notOver = false;
            return result;
        }

        this.isItYourTurn = !this.isItYourTurn;
        return result;
    }

    private RoundResult makeRoundResult(String input) {
        int strike = 0;
        int ball = 0;

        for(int i = 0; i < 3; i++) {  // 현재 라운드 판단
            if(this.rndNumber.charAt(i) == input.charAt(i)) {
                strike ++;
                continue;
            }
            if(this.rndNumber.indexOf(input.charAt(i)) != -1) {
                ball ++;
            }
        }

        return new RoundResult(ball, strike);
    }

    public Boolean yourTurn() {
        return this.isItYourTurn;
    }

    public Boolean notOver() {
        return this.notOver;
    }

    public static String makeRndNumber() {
        Integer temp = (int)(Math.random() * 1000);
        return String.valueOf(temp);
    }
}
