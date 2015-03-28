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
        System.out.println("1/1: " + new Fraction(1,1));
        System.out.println("1/2: " + new Fraction(1,2));
        System.out.println("1/3: " + new Fraction(1,3));
        System.out.println("1/4: " + new Fraction(1,4));
        System.out.println("1/5: " + new Fraction(1,5));
        System.out.println("1/7: " + new Fraction(1,6));
        System.out.println("1/7: " + new Fraction(1,7));
    }
    
    @Test
    public void printBigFractions() {
        System.out.println("1/81: " + new Fraction(1, 81));
        System.out.println("1/983: " + new Fraction(1, 983));
    }
    
    @Test
    public void testUnitFractions() {
        Assert.assertEquals(new Fraction(1, 1).toString(), "1");
        Assert.assertEquals(new Fraction(1, 2).toString(), "0.5");
        Assert.assertEquals(new Fraction(1, 3).toString(), "0.(3)");
        Assert.assertEquals(new Fraction(1, 4).toString(), "0.25");
        Assert.assertEquals(new Fraction(1, 5).toString(), "0.2");
        Assert.assertEquals(new Fraction(1, 6).toString(), "0.1(6)");
        Assert.assertEquals(new Fraction(1, 7).toString(), "0.(142857)");
    }
    
    @Test
    public void testCycleLength() {
        Assert.assertEquals(new Fraction(1, 1).cycleLength(), 0);
        Assert.assertEquals(new Fraction(1, 2).cycleLength(), 0);
        Assert.assertEquals(new Fraction(1, 3).cycleLength(), 1);
        Assert.assertEquals(new Fraction(1, 4).cycleLength(), 0);
        Assert.assertEquals(new Fraction(1, 5).cycleLength(), 0);
        Assert.assertEquals(new Fraction(1, 6).cycleLength(), 1);
        Assert.assertEquals(new Fraction(1, 7).cycleLength(), 6);
    }
}