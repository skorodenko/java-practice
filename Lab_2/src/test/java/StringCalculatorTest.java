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
    public void gives_null_for_empty_string() throws Exception {
        assertEquals(0, calculator.Add(""));
    }

    @Test
    public void equals_to_one() throws Exception {
        assertEquals(1, calculator.Add("1"));
    }

    @Test
    public void equals_to_six() throws Exception {
        assertEquals(6, calculator.Add("1,2,3"));
    }

    // Step 2 tests
    @Test
    public void equals_to_seven() throws Exception {
        assertEquals(7, calculator.Add("1,2,1,3"));
    }

    @Test
    public void equals_to_fifteen() throws Exception {
        assertEquals(15, calculator.Add("1,2,3,4,5"));
    }

    // Step 3 tests
    @Test
    public void equals_to_three() throws Exception {
        assertEquals(3, calculator.Add("1,1\n1"));
    }

    @Test
    public void equals_to_null_with_newline() throws Exception {
        assertEquals(0, calculator.Add("\n"));
    }

    // Step 4 tests
    @Test
    public void semicolon_equal_to_four() throws Exception {
        assertEquals(4, calculator.Add("//;\n1;2\n1"));
    }

    @Test
    public void dot_equal_to_seven() throws Exception {
        assertEquals(7, calculator.Add("//.\n1.2\n3.1"));
    }

    // Step 5 tests
    @Test
    public void exception_thrown_one_negative() {
        boolean thrown = false;
        try {
            calculator.Add("1,-1");
        } catch (Exception e) {
            assertEquals("Negatives are not allowed: [-1]", e.getMessage());
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void exception_thrown_three_negatives() {
        boolean thrown = false;
        try {
            calculator.Add("1,-1,-2,-3");
        } catch (Exception e) {
            assertEquals("Negatives are not allowed: [-1, -2, -3]", e.getMessage());
            thrown = true;
        }
        assertTrue(thrown);
    }

    // Step 6 + GetCalledCount tests
    @Test
    public void more_than_thousand_does_not_count() throws Exception {
        assertEquals(1, calculator.Add("//.\n1.2000\n30000.12000"));
    }

    @Test
    public void get_called_count_test() throws Exception {
        assertEquals(0, calculator.GetCalledCount());
        calculator.Add("");
        calculator.Add("");
        calculator.Add("");
        assertEquals(3, calculator.GetCalledCount());
    }

    // Step 7 tests
    @Test
    public void non_atomic_delimiter() throws Exception {
        assertEquals(7, calculator.Add("//[***]\n1***2***3\n1"));
    }

    // Step 8 tests
    @Test
    public void multiple_atomic_delimiter() throws Exception {
        assertEquals(6, calculator.Add("//[*][%]\n1*2%3"));
    }
}