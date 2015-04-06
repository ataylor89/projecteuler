package tests;

import org.junit.Test;
import util.FareySequence;
import util.Fraction;

/**
 *
 * @author ataylor
 */
public class FareySequenceTest {
    
    @Test
    public void test() {
        test(8);
    }
    
    private void test(int n) {
        FareySequence seq = new FareySequence(n);
        Fraction next;
        
        while ((next = seq.next()) != null) 
            System.out.println(next.numerator() + "/" + next.denominator());
    }
}
