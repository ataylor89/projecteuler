package tests;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import util.Numbers;
import util.RunningTime;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class NumbersTest {
    
//    @Test
    public void testDigitalRoot() {
        long begin = System.currentTimeMillis();
        
        int[] cases = new int[] {5, 9, 12, 135, 490993, 14578};
        
        for (int n : cases) 
            System.out.println("Digital root for " + n + ": " + Numbers.digitalRoot(n));
        
        RunningTime.print(begin);
    }
    
//    @Test
    public void testTotientFunction() {
        long begin = System.currentTimeMillis();
        
        for (int n = 1; n < 100; n++) 
            System.out.printf("phi(%d) = %d%n", n, Numbers.phi(n));
        
        RunningTime.print(begin);
    }
    
    @Test
    public void testGcdForPrimes() {
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(50);
        sieve.generate(true);
        
        List<Integer> primes = sieve.getPrimes();
        
        for (int p : primes)
            for (int q : primes)
                if (p != q)
                    Assert.assertEquals(1, Numbers.gcd(p,q));
    }
    
    @Test
    public void testGcdForRange() {
        for (int n = 2; n < 20; n++) 
            for (int m = 1; m <= n; m++)
                System.out.printf("gcd(%d,%d) = %d%n", m, n, Numbers.gcd(n,m));
    }
    
    @Test
    public void testGcdForLargeNumbers() {
        long a = 1234567892L;
        long b = 2456876272L;
        
        System.out.printf("gcd(%d,%d) = %d%n", a, b, Numbers.gcd(a,b));
    }
}