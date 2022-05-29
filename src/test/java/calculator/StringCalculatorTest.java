package calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class StringCalculatorTest {

    @Test
    void 덧셈() {
        List<String> strings = new ArrayList<>(Arrays.asList("1", "+", "2"));

        Integer result = new StringCalculator().run(strings);
        assert result == 3;
    }

    @Test
    void 뺄셈() {
        List<String> strings = new ArrayList<>(Arrays.asList("5", "-", "3"));

        Integer result = new StringCalculator().run(strings);
        assert result == 2;
    }

    @Test
    void 곱셈() {
        List<String> strings = new ArrayList<>(Arrays.asList("2", "*", "5"));

        Integer result = new StringCalculator().run(strings);
        assert result == 10;
    }

    @Test
    void 나눗셈() {
        List<String> strings = new ArrayList<>(Arrays.asList("4", "/", "2"));

        Integer result = new StringCalculator().run(strings);
        assert result == 2;
    }
}