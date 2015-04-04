package problems;

import java.math.BigInteger;
import util.PellEquation;
import util.Numbers;
import util.RunningTime;

/**
 *
 * @author ataylor
 */
public class Problem66 {
    
    public void solve() {
        BigInteger largestX = BigInteger.ZERO;
        int answer = 0;
        
        for (int N = 2; N <= 1000; N++) {
            if (Numbers.isPerfectSquare(N))
                continue;
            
            PellEquation eq = new PellEquation(N);
            
            BigInteger[] soln = eq.solve();
            BigInteger x = soln[0], y = soln[1];
            
            if (x.compareTo(largestX) > 0) {
                largestX = x;
                answer = N;
            }
        }
        
        System.out.println("Largest X: " + largestX);
        System.out.println("Value of N: " + answer);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem66().solve();
        
        RunningTime.print(begin);
    }
}
