package tests;

import org.junit.Test;
import util.Numbers;
import util.RunningTime;

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
    
    @Test
    public void testTotientFunction() {
        long begin = System.currentTimeMillis();
        
        for (int n = 1; n < 100; n++) 
            System.out.printf("phi(%d) = %d%n", n, Numbers.phi(n));
        
        RunningTime.print(begin);
    }
}