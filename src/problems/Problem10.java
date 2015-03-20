package problems;

import java.util.List;
import util.PrimeFinder;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem10 {
    
    private PrimeFinder primeFinder;
    private int depth = 2000000; // 2 million
    
    public Problem10() {
        primeFinder = new SieveOfEratosthenes(depth);
        primeFinder.generate(true);
    }
    
    public void solve() {
        List<Integer> primes = primeFinder.getPrimes();
        
        long sum = 0;
        for (int p : primes)
            sum += p;
        
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
       new Problem10().solve();
    }
}
