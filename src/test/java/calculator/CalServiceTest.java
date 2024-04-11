package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalServiceTest {
    // Extra. 결과값이 float 표현 범위를 넘어선 경우
    
    // 3. 입력 숫자가 Float 범위를 넘어간 경우
    @Test
    @DisplayName("Float out of range")
    void thisIsTooBig() {
        assertThatThrownBy(() -> {
            CalService calculator = new CalService("10000000000000000000 + 10000000000000000000");
            calculator.makeResult();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("너무 큰 숫자입니다");
    }
    
    // 4. 숫자 자리에 제대로 입력을 하지 않은 경우 & 5. 띄어쓰기를 안 한 경우 & 
    // 2. 빈 칸이 입력된 경우 & 1. 아무것도 입력하지 않고 enter를 누른 경우
    @ParameterizedTest
    @ValueSource(strings = {"3_0", "3/0", "3 -0", " # * 3", "", " ", "3  1"})
    @DisplayName("Invalid Input")
    void notGoodInput() {
        assertThatThrownBy(() -> {
            CalService calculator = new CalService("3/0");
            calculator.makeResult();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("식이 제대로 입력되지 않음");
    }
    
    // 6. 연산자 자리에 & 4 개의 연산자 외의 문자가 입력된 경우
    @ParameterizedTest
    @DisplayName("Undefined operator")
    @ValueSource(strings = {"3 _ 0", "3 가 0", "3 a 0"})
    void strangeOperator(String input) {
        CalService calculator = new CalService(input);
        assertThatThrownBy(calculator::makeResult).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산자가 제대로 입력되지 않음");
    }    
    
    // 7. 0 으로 나눈 경우
    @Test
    @DisplayName("What if divide with zero")
    void divideWithZero() {
        CalService calculator = new CalService("3 / 0");
        assertThatThrownBy(calculator::makeResult).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 으로 나눌 수 없음");
    }
}
