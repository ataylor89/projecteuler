package problems;

import util.Divisors;

/**
 *
 * @author ataylor
 */
public class Problem23 {
    
    private int upperLimit = 28123;
    private Divisors[] divisors;
    
    public Problem23() {
        divisors = new Divisors[upperLimit + 1];
        for (int i = 1; i < divisors.length; i++) 
            divisors[i] = new Divisors(i);
    }
    
    public void solve() {
        int sum = 0;
        
        for (int n = 1; n <= upperLimit; n++) 
            if (!isAbundantSum(n))
                sum += n;
        
        System.out.println("Sum: " + sum);
    }
    
    private boolean isAbundantSum(int n) {
        for (int i = 1; i * 2 <= n; i++) {
            int j = n - i;
            
            if (isAbundant(i) && isAbundant(j))
                return true;
        }
        return false;
    }
    
    private boolean isAbundant(int n) {
        return divisors[n].sumProper() > n;
    }
    
    public static void main(String[] args) {
        new Problem23().solve();
    }
}
