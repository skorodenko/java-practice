import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matcher.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    public void gives_null_for_empty_string() {
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void equals_to_one() {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void equals_to_six() {
        assertEquals(6, calculator.Add("1,2,3"));
    }
}