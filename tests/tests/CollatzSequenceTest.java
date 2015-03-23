package tests;

import org.junit.Assert;
import org.junit.Test;
import util.CollatzSequence;

/**
 *
 * @author ataylor
 */
public class CollatzSequenceTest {
    
    @Test
    public void testKnownSequence() {
        CollatzSequence s = new CollatzSequence(13);
        System.out.println(s);
        
        String expected = "[13, 40, 20, 10, 5, 16, 8, 4, 2, 1]";
        Assert.assertEquals(s.toString(), expected);
    }
    
    @Test
    public void testLongSequence() {
        long begin = System.currentTimeMillis();
        
        int start = 113383;
        CollatzSequence s = new CollatzSequence(start);
        System.out.println("Start: " + s.get(0) + ". Length: " + s.length());
        clock(begin);
    }
    
    private void clock(long begin) {
        long runningTime = System.currentTimeMillis() - begin;
        
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}