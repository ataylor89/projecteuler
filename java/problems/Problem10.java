package problems;

import java.util.List;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem10 {
    
    private SieveOfEratosthenes sieve;
    private int size = 2000000; // 2 million
    
    public Problem10() {
        sieve = new SieveOfEratosthenes(size);
        sieve.generate(true);
    }
    
    public void solve() {
        List<Integer> primes = sieve.getPrimes();
        
        long sum = 0;
        for (int p : primes)
            sum += p;
        
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
       new Problem10().solve();
    }
}
