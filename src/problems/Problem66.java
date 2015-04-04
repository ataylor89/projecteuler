package problems;

import java.math.BigInteger;
import util.PellEquation;
import util.Numbers;

/**
 *
 * @author ataylor
 */
public class Problem66 {
    
    public void solve() {
        BigInteger largestX = BigInteger.ZERO;
        int answer = 0;
        
        for (int D = 2; D <= 1000; D++) {
            if (Numbers.isPerfectSquare(D))
                continue;
            
            PellEquation eq = new PellEquation(D);
            
            BigInteger[] soln = eq.solve();
            BigInteger x = soln[0], y = soln[1];
            
            if (x.compareTo(largestX) > 0) {
                largestX = x;
                answer = D;
            }
        }
        
        System.out.println("Largest X: " + largestX);
        System.out.println("D value: " + answer);
    }
    
    public static void main(String[] args) {
        new Problem66().solve();
    }
}
