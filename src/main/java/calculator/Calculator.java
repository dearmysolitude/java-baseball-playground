package calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float answer;
        
        while(true) {
            System.out.println("사칙 연산을 진행할 식을 입력하세요.");
            System.out.println("각 요소는 띄어쓰기로 구분하고, 사칙 연산 순서가 아닌 순차적으로 계산합니다. 괄호 연산은 지원하지 않습니다.");
            String inputValue = scanner.nextLine();

            CalService calService = new CalService(inputValue);

            try {
                answer = calService.makeResult();
                System.out.println("계산 결과: "+ answer);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("[ERROR] " + iae.getMessage());
            }
        }
        scanner.close();
    }
}
