package calculator;

public class CalculatorApplication {
    private String[] calUnits;
    public CalculatorApplication(InputManager inputManager) {
        calUnits = inputManager.getCalUnits();
    }
    // 계산 결과를 리턴
    public Integer doCalculate() {
        return null;
    }
}
