package problems;

import util.SquareRoot;

/**
 *
 * @author ataylor
 */
public class Problem64 {
    
    public void solve() {
        int upperLimit = 10000;
        int num = 0;
        
        for (int n = 2; n <= upperLimit; n++) {
            SquareRoot sqrtN = new SquareRoot(n);
            
            if (sqrtN.period() % 2 == 1)
                num++;
        }
        
        System.out.println("Continued fractions for N <= " + upperLimit + " with odd period: " + num);
    }
    
    public static void main(String[] args) {
        new Problem64().solve();
    }
}
