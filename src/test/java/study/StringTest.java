package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("replace() test")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    @DisplayName("split() test")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual[0]).isEqualTo("1");
        assertThat(actual[1]).isEqualTo("2");
    }
    
    @Test
    @DisplayName("subString() test")
    void subString() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("charAt() test")
    void charAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }   
    
    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsExceptionTest")
    void charAtOutOfIndex() {
        assertThatThrownBy(() ->{
            char actual = "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("range: 3");
    }
}
