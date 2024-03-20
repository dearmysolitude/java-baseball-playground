package calculator;

import java.nio.file.LinkPermission;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputManager inputManager = new InputManager(scanner);
        CalculatorApplication calculatorApplication = new CalculatorApplication(inputManager);

        Integer answer;
        
        System.out.println("사칙 연산을 진행할 식을 입력하세요.");
        System.out.println("각 요소는 띄어쓰기로 구분하고, 사칙 연산 순서가 아닌 순차적으로 계산합니다. 괄호 연산은 지원하지 않습니다.");
        
        inputManager.checkInputValues();
        answer = calculatorApplication.doCalculate();
        
        System.out.println("계산 결과: "+ answer);
    }
}
