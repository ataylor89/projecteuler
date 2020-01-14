package problems;

import util.Numbers;
import util.Strings;

/**
 *
 * @author ataylor
 */
public class Problem70 {
    
    public void solve() {
        long limit = (long) Math.pow(10, 7);
        
        double minRatio = 0.0;
        long bestN = 0;
        
        for (long n = 2; n < limit; n++) {
            long phiN = Numbers.phi(n);
            
            if (!isPermutation(phiN, n))
                continue;
            
            double ratio = (double) n / (double) phiN;
            
            if (ratio < minRatio || minRatio == 0) {
                minRatio = ratio;
                bestN = n;
            }
        }
        
        System.out.println("Mininum ratio: " + minRatio);
        System.out.println("Best N: " + bestN);
    }
    
    private boolean isPermutation(long phiN, long n) {
        String s = Strings.alphabetize(phiN);
        String t = Strings.alphabetize(n);
        
        return s.equals(t);
    }
    
    public static void main(String[] args) {
        new Problem70().solve();
    }
    
}
