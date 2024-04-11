package calculator;

public class CalService {
    private final String[] values;
    private Float answer;
    
    public CalService(String inputValue) {
        this.values = inputValue.split(" ");
        try {
            answer = Float.parseFloat(values[0]);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("식이 제대로 입력되지 않음: constructor generation failed");
        }
        checkNumberSize(values[0].length());
    }
    
    public Float makeResult() {
        try {
            for (int i = 1; i < values.length; i += 2) {
                answer = doCalculate(values[i], Float.parseFloat(values[i + 1]));
                checkNumberSize(values[i+1].length());
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("식이 제대로 입력되지 않음: failed parsing numbers");
        }
        
        checkNull(answer);
        return answer;
    }
    
    private void checkNull(Float number) {
        if (number == null) {
            throw new IllegalArgumentException("출력값이 생성되지 않음");
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
                throw new IllegalArgumentException("연산자가 제대로 입력되지 않음");
        }
    }
    
    private void ifDividedByZero(Float number) {
        if(number == 0) {
            throw new IllegalArgumentException("0 으로 나눌 수 없음");
        }
    }
    
    private void checkNumberSize(int inputSize) {
        if(inputSize > 10) {
            throw new IllegalArgumentException("너무 큰 숫자입니다");
        }
    }
}
