package tests;

import org.junit.Assert;
import org.junit.Test;
import util.FareySequence;

/**
 *
 * @author ataylor
 */
public class FareyTest {
    
    @Test
    public void compareSmall() {
        for (int n = 2; n < 10; n++) {
            FareySequence s = FareySequence.quickly(n);
            FareySequence t = FareySequence.recursively(n);
            
            System.out.println(s);
            System.out.println(t);
            
            Assert.assertEquals(s, t);
        }
    }
    
}