package problems;

import util.DigitFactorial;

/**
 *
 * @author ataylor
 */
public class Problem74 {
    
    public void solve() {
        int limit = (int) Math.pow(10, 6);
        
        int count = 0;
        for (int n = 0; n < limit; n++) {
            DigitFactorial c = new DigitFactorial(n);
            
            if (c.length() == 60) 
                count++;
        }
        
        System.out.println("Count: " + count);
    }
    
    public static void main(String[] args) {
        new Problem74().solve();
    }
}
