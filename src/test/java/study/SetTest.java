package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;
    
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set size Test")
    void setSizeConfirm() {
        assertThat(numbers).hasSize(3);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Parameterized Test practice: Weather set contains certain value")
    void setValueTest(int number) {
        assertThat(numbers).contains(number);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"Test:test", "tEST:test", "Java:java"}, delimiter = ':')
    @DisplayName("If expected value is not boolean: Should generate expected lower case value")
    void setStringValueTest(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertEquals(expected, actualValue);
    }
    
}
