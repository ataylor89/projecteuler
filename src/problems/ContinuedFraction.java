package problems;

import org.apache.commons.math3.fraction.BigFraction;

/**
 *
 * @author ataylor
 */
public abstract class ContinuedFraction {

    public BigFraction evaluate(int iterations) {
        BigFraction a, b, r = new BigFraction(0);
        
        for (int i = iterations; i > 0; i--) {
            a = new BigFraction(getA(i));
            b = new BigFraction(getB(i));
            
            r = b.divide(a.add(r));
        }
        a = new BigFraction(getA(0));
        
        return a.add(r);
    }
    
    public abstract int getA(int n);
    
    public abstract int getB(int n);
}
