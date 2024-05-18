package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BPTest {
    BaseballPlayground baseballPlayground = new BaseballPlayground("123");

    // doRound
    @ParameterizedTest
    @DisplayName("doRound 테스트")
    @CsvSource({
            "444, 0, 0", // 무득점
            "847, 0, 0",
            "999, 0, 0",
            "367, 1, 0", // 볼 1개
            "287, 1, 0",
            "871, 1, 0",
            "673, 0, 1", // 스트라이크 1개
            "628, 0, 1",
            "145, 0, 1",
            "327, 1, 1", // 볼 1 개, 스트라이크 1 개
            "139, 1, 1",
            "351, 2, 0", // 볼 2 개
            "219, 2, 0",
            "129, 0, 2", // 스트라이크 2개
            "823, 0, 2",
            "123, 0, 3" // 스트라이크 3 개
    })
    public void testDoRound(String input, int expectedBall, int expectedStrike) {
        RoundResult result = baseballPlayground.doRound(input);
        assertTrue(checkResult(result, expectedBall, expectedStrike));
    }

    private boolean checkResult(RoundResult result, int ball, int strike) {
        return result.getStrike() == strike && result.getBall() == ball;
    }
}
