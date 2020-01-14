package problems;

import util.SquareRoot;

/**
 *
 * @author ataylor
 */
public class Problem64 {
    
    public void solve() {
        int upperLimit = 10000;
        int count = 0;
        
        for (int n = 2; n <= upperLimit; n++) {
            SquareRoot sqrtN = new SquareRoot(n);
            
            if (sqrtN.period() % 2 == 1)
                count++;
        }
        
        System.out.println("Continued fractions for N <= " + upperLimit + " with odd period: " + count);
    }
    
    public static void main(String[] args) {
        new Problem64().solve();
    }
}
