package util;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static util.Numbers.isPerfectSquare;
import org.apache.commons.math3.fraction.BigFraction;

/**
 * This class solves any Pell equation of the form x^2 - Ny^2 = 1,
 * where N is a nonsquare positive integer.
 * 
 * @author ataylor
 */
public class PellEquation {
    
    private final int N;
    private final String errorMsg = "N must be a positive nonsquare integer.";
    
    public PellEquation(int N) {
        this.N = N;
        
        if (N < 2 || isPerfectSquare(N))
            throw new IllegalArgumentException(errorMsg);
    }
    
    public BigInteger[] solve() {
        ContinuedFraction sqrtN = new SquareRoot(N);
        for (int n = 0; n >= 0; n++) {
            BigFraction frac = sqrtN.evaluate(n);
            
            BigInteger P = frac.getNumerator();
            BigInteger Q = frac.getDenominator();
            BigInteger D = BigInteger.valueOf(N);
            
            if (P.multiply(P).subtract(D.multiply(Q).multiply(Q)).equals(ONE))
                return new BigInteger[] {P, Q};
        }
        return null;
    }    
}
