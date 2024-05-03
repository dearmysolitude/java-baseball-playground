package baseball;

public class BaseballPlayground {
    private String rndNumber;  // 어디에 어떤 숫자가 있는지 판단하는 데에는 Integer 보다 String 이 유리.
    private Boolean isItYourTurn;
    private Boolean notOver;

    public BaseballPlayground() {
        this.rndNumber = makeRndNumber();
        this.isItYourTurn = true;
        this.notOver = true;
    }

    private String getRndNumber() {
        return this.rndNumber;
    }

    // 라운드 결과를 확인하는 메인 로직, 입력은 문자열로 받는다.
    public RoundResult doGame(String input) {
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

//    private int itIsStrike(String input, int index) {
//        if(rndNumber.charAt(index) == input.charAt(index)) {
//            return
//        }
//    }

    public static String makeRndNumber() {
        Integer temp = (int)(Math.random() * 1000);
        return String.valueOf(temp);
    }
}
