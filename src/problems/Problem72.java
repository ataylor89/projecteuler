package problems;

import util.Numbers;

/**
 *
 * @author ataylor
 */
public class Problem72 {
    
    public void solve() {
        int N = (int) Math.pow(10, 6);
        long count = 0;
        
        for (int k = 1; k <= N; k++)
            count += Numbers.phi(k);
        
        System.out.printf("N(%d) = %d%n", N, count - 1);
    }
    
    public static void main(String[] args) {
        new Problem72().solve();
    }
}
