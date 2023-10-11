import com.rktech.rktech.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

    public class CalculatorTest {

        @Test
        public void testAdd() {
            Calculator calculator = new Calculator();
            int result = calculator.add(2, 4);
            assertEquals(6, result);
        }

        @Test
        public void testSubtract() {
            Calculator calculator = new Calculator();
            int result = calculator.subtract(6, 3);
            assertEquals(3, result);
        }
    }

