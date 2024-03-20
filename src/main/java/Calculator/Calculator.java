package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사칙 연산을 진행할 식을 입력하세요.");
        System.out.println("각 요소는 띄어쓰기로 구분하고, 사칙 연산 순서가 아닌 순차적으로 계산합니다. 괄호 연산은 지원하지 않습니다.");
        
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        String recentOperator = " ";

        try{
            Integer answer = calculateWithString(values, null, recentOperator);
            System.out.println(answer);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static Integer calculateWithString(String[] values, Integer answer, String recentOperator) {
        for(String value: values) {
            try {
                Integer temp = Integer.parseInt(value);
                if(answer == null) {
                    answer = temp;
                } else {
                    answer = doCalculation(recentOperator, temp, answer);
                }
            } catch(NumberFormatException e) {
                if(answer == null) {
                    throw new IllegalArgumentException("첫 문자는 숫자여야 합니다!");
                }
                recentOperator = value;
            }
        }
        return answer;
    }

    private static Integer doCalculation(String operator, Integer number, Integer answer) {
        switch(operator) {
            case("+"):
                return number + answer;
            case("-"):
                return answer - number;
            case("*"):
                return answer * number;
            case("/"):
                return answer / number;
            default:
                throw new IllegalArgumentException("적절한 연산자를 입력해야 합니다: +, -, *, /");
        }
    }
}
