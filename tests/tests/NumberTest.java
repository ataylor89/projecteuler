package tests;

import org.junit.Test;
import util.Numbers;
import util.RunningTime;

/**
 *
 * @author ataylor
 */
public class NumberTest {
    
    @Test
    public void testDigitalRoot() {
        long begin = System.currentTimeMillis();
        
        int[] cases = new int[] {5, 9, 12, 135, 490993, 14578};
        
        for (int n : cases) 
            System.out.println("Digital root for " + n + ": " + Numbers.digitalRoot(n));
        
        RunningTime.print(begin);
    }
}