package problems;

import java.util.List;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem07 {
    
    public void solve() {
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);
        sieve.generate(true);
        
        List<Integer> primes = sieve.getPrimes(10001);
        
        System.out.println(primes.get(primes.size() - 1));
    }
    
    public static void main(String[] args) {
        new Problem07().solve();
    }
}
