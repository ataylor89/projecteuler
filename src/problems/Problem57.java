package problems;

import util.ContinuedFraction;
import org.apache.commons.math3.fraction.BigFraction;

/**
 *
 * @author ataylor
 */
public class Problem57 {
    
    public static void main(String[] args) {
        SquareRootTwo sqrt2 = new SquareRootTwo();
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
    
    static class SquareRootTwo extends ContinuedFraction {
        @Override
        public int getA(int n) {
            return (n > 0) ? 2 : 1;
        }

        @Override
        public int getB(int n) {
            return 1;
        }
    }
}
