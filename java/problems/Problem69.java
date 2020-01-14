package problems;

import util.Numbers;

/**
 *
 * @author ataylor
 */
public class Problem69 {
    
    public void solve() {
        double maxRatio = 0.0;
        int bestN = 0;
        
        for (int n = 2; n <= 1000000; n++) {
            double ratio = (double) n / (double) Numbers.phi(n);
            
            if (ratio > maxRatio) {
                maxRatio = ratio;
                bestN = n;
            }
        }
        
        System.out.println("Maximum ratio: " + maxRatio);
        System.out.println("Value of N: " + bestN);
    }
    
    public static void main(String[] args) {
        new Problem69().solve();
    }
}
