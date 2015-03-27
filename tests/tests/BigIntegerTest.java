package tests;

import org.junit.Assert;
import org.junit.Test;
import util.BigInteger;
/**
 *
 * @author ataylor
 */
public class BigIntegerTest {
    
    @Test
    public void testAddition() {
        BigInteger five = new BigInteger("5");
        BigInteger one = BigInteger.ONE;
        
        BigInteger six = five.add(one);
        Assert.assertEquals(six, new BigInteger("6"));
        
        BigInteger ninetyEight = six.add(new BigInteger("92"));
        Assert.assertEquals(ninetyEight, new BigInteger("98"));
        
        BigInteger oneHundredTwo = ninetyEight.add(new BigInteger("4"));
        System.out.println("One hundred two: " + oneHundredTwo);
        
        Assert.assertEquals(oneHundredTwo, new BigInteger("102"));
    }
    
    @Test
    public void testMultiplication() {
        BigInteger five = new BigInteger("5");
        BigInteger thirtyFive = five.multiply(7);
        
        System.out.println("Thirty five: " + thirtyFive);
        Assert.assertEquals(thirtyFive, new BigInteger("35"));
    }
    
    @Test
    public void testLargeMultiplication() {
        String s = "";
        for (int i = 0; i < 50; i++)
            s += "9";
        
        BigInteger num = new BigInteger(s).multiply(100);
        java.math.BigInteger comparison = new java.math.BigInteger(s).multiply(new java.math.BigInteger("100"));
        
        System.out.println("Lots of 9's times 100: " + num);
        Assert.assertEquals(num.toString(), comparison.toString());
    }
}