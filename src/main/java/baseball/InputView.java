package baseball;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String returnInputString() {
        String input;
        do {
            input = getValidInput();
        } while (input == null);
        return input;
    }

    private String getValidInput() {
        String input = null;
        try {
            input = takeInput();
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        return input;
    }

    private String takeInput() throws IllegalArgumentException{
        String input = scanner.nextLine();

        checkInputFormat(input);
        checkNumber(input);

        return input;
    }

    private static void checkInputFormat(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private void checkNumber(String input) throws IllegalArgumentException {
        String errorMsg = "[ERROR] 1 ~ 9 숫자를 중복되지 않도록 사용한 세자리 수를 입력해야 합니다.";

        checkCondition(input.contains("0"), errorMsg);
        checkCondition(input.length() != 3, errorMsg);
        checkDuplication(input, errorMsg);
    }

    private void checkCondition(boolean condition, String errorMsg) throws IllegalArgumentException {
        if (condition) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private void checkDuplication(String input, String errorMsg) throws IllegalArgumentException {
        boolean[] checkbox = new boolean[10];

        for(char character: input.toCharArray()) {
            int temp = Integer.parseInt(String.valueOf(character));
            checkCondition(checkbox[temp], errorMsg);
            checkbox[temp] = true;
        }
    }

    public Boolean endThisGame()  {
        String input = getAnswer();

        if(input.equals("2")) {
            closeScanner();
            return true;
        }

        return false;
    }

    private String getAnswer() {
        String input;

        do {
            System.out.println("게임을 계속하시겠습니까? 1: 게임을 새로 시작, 2: 게임을 종료");
            input = scanner.nextLine();
        } while (!correctAnswer(input));

        return input;
    }

    private boolean correctAnswer(String input) {
        try {
            checkInputFormat(input);
            checkCondition(!(input.equals("1") || input.equals("2")), "[ERROR] 1 혹은 2를 입력해 주세요.");
            return true;
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        return false;
    }

    public void closeScanner() {
        this.scanner.close();
    }
}
