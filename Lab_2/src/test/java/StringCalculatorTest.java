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

    // Step 1 tests
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

    // Step 2 tests
    @Test
    public void equals_to_seven() {
        assertEquals(7, calculator.Add("1,2,-2,6"));
    }

    @Test
    public void equals_to_fifteen() {
        assertEquals(15, calculator.Add("1,2,3,4,5"));
    }

    // Step 3 tests
    @Test
    public void equals_to_three() {
        assertEquals(3, calculator.Add("1,1\n1"));
    }

    @Test
    public void equals_to_null_with_newline() {
        assertEquals(0, calculator.Add("\n"));
    }

}