package tests;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import util.DigitFactorial;

/**
 *
 * @author ataylor
 */
public class DigitFactorialTest {
    
    @Test
    public void printRange() {
        for (int n = 0; n <= 10; n++)
            System.out.println(new DigitFactorial(n));
    }
    
    @Test
    public void testExpected() {
        Assert.assertEquals(new DigitFactorial(169).terms(), Arrays.asList(169, 363601, 1454));
        Assert.assertEquals(new DigitFactorial(871).terms(), Arrays.asList(871, 45361));
        Assert.assertEquals(new DigitFactorial(872).terms(), Arrays.asList(872, 45362));
    }
}