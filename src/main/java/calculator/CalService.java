package calculator;

public class CalService {
    private final String[] values;
    private Float answer;
    
    public CalService(String inputValue) {
        this.values = inputValue.split(" ");
        try {
            answer = Float.parseFloat(values[0]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("첫 입력값은 숫자여야 합니다.");
        }
    }
    
    public Float makeResult() {
        try {
            for (int i = 1; i < values.length; i += 2) {
                answer = doCalculate(values[i], Float.parseFloat(values[i + 1]));
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자가 제대로 입력되지 않았음.");
        }
        
        checkNull(answer);
        return answer;
    }
    
    private void checkNull(Float number) {
        if (number == null) {
            throw new IllegalArgumentException("출력값이 생성되지 않음.");
        }
    }
    
    private Float doCalculate(String operator, Float number) {
        switch(operator) {
            case "+":
                return answer + number;
            case "-":
                return answer - number;
            case "*":
                return answer * number;
            case "/":
                ifDividedByZero(number);
                return answer / number;
            default:
                throw new IllegalArgumentException("연산자가 제대로 입력되지 않았음.");
        }
    }
    
    private void ifDividedByZero(Float number) {
        if(number == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없음.");
        }
    }
}
