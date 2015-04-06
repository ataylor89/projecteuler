package tests;

import org.junit.Assert;
import org.junit.Test;
import util.Fraction;

/**
 *
 * @author ataylor
 */
public class FractionTest {
    
    @Test
    public void printUnitFractions() {
        System.out.println("1/1: " + new Fraction(1,1).asDecimal());
        System.out.println("1/2: " + new Fraction(1,2).asDecimal());
        System.out.println("1/3: " + new Fraction(1,3).asDecimal());
        System.out.println("1/4: " + new Fraction(1,4).asDecimal());
        System.out.println("1/5: " + new Fraction(1,5).asDecimal());
        System.out.println("1/7: " + new Fraction(1,6).asDecimal());
        System.out.println("1/7: " + new Fraction(1,7).asDecimal());
    }
    
    @Test
    public void printBigFractions() {
        System.out.println("1/81: " + new Fraction(1, 81).asDecimal());
        System.out.println("1/983: " + new Fraction(1, 983).asDecimal());
    }
    
    @Test
    public void testUnitFractions() {
        Assert.assertEquals(new Fraction(1, 1).asDecimal(), "1");
        Assert.assertEquals(new Fraction(1, 2).asDecimal(), "0.5");
        Assert.assertEquals(new Fraction(1, 3).asDecimal(), "0.(3)");
        Assert.assertEquals(new Fraction(1, 4).asDecimal(), "0.25");
        Assert.assertEquals(new Fraction(1, 5).asDecimal(), "0.2");
        Assert.assertEquals(new Fraction(1, 6).asDecimal(), "0.1(6)");
        Assert.assertEquals(new Fraction(1, 7).asDecimal(), "0.(142857)");
    }
    
    @Test
    public void testCycleLength() {
        Assert.assertEquals(new Fraction(1, 1).period(), 0);
        Assert.assertEquals(new Fraction(1, 2).period(), 0);
        Assert.assertEquals(new Fraction(1, 3).period(), 1);
        Assert.assertEquals(new Fraction(1, 4).period(), 0);
        Assert.assertEquals(new Fraction(1, 5).period(), 0);
        Assert.assertEquals(new Fraction(1, 6).period(), 1);
        Assert.assertEquals(new Fraction(1, 7).period(), 6);
    }
}