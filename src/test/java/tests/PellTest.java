package tests;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;
import util.Numbers;
import util.PellEquation;
import util.RunningTime;

/**
 *
 * @author ataylor
 */
public class PellTest {
    
    @Test
    public void printSolutions() {
        long begin = System.currentTimeMillis();
        
        for (int n = 2; n <= 1000; n++) {
            if (Numbers.isPerfectSquare(n))
                continue;
            
            printSolution(n);
        }
        
        RunningTime.print(begin);
    }
    
    private void printSolution(int n) {
        BigInteger[] soln = new PellEquation(n).solve();
        
        if (soln == null)
            System.out.printf("No solution for N=%d.", n);
        else
            System.out.printf("N=%d x=%s y=%s%n", n, soln[0], soln[1]);
    }
    
    @Test 
    public void test13() {
        BigInteger[] soln = new PellEquation(13).solve();
        BigInteger[] expected = new BigInteger[] {BigInteger.valueOf(649), BigInteger.valueOf(180)};
        
        Assert.assertArrayEquals(soln, expected);
    }
}