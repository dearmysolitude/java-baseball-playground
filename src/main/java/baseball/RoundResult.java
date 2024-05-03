package baseball;

public class RoundResult {  //DTO
    private final Integer ball;
    private final Integer strike;

    public RoundResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public RoundResult(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getBall() {
        return this.ball;
    }

    public Integer getStrike() {
        return this.strike;
    }
}
