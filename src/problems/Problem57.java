package problems;

import util.ContinuedFraction;
import org.apache.commons.math3.fraction.BigFraction;
import util.ContinuedFractions;

/**
 *
 * @author ataylor
 */
public class Problem57 {
    
    public static void main(String[] args) {
        ContinuedFraction sqrt2 = ContinuedFractions.squareRootTwo;
        int count = 0;
        
        for (int i = 1; i <= 1000; i++) {
            BigFraction f = sqrt2.evaluate(i);
            
            int nl = f.getNumerator().toString().length();
            int dl = f.getDenominator().toString().length();
            
            if (nl > dl) 
                count++;
        }
        
        System.out.println(count);
    }
    
    
}
