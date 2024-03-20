package calculator;

import java.util.Scanner;

public class InputManager {
    private final String[] splitedValues;
    
    public InputManager(Scanner scanner) {
        String inputValue = scanner.nextLine();
        this.splitedValues = inputValue.split(" ");
    }
    
    public void checkInputValues() {
        
    }
    
    public String[] getCalUnits() {
        return splitedValues;
    }
}
