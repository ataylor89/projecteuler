package problems;

import java.util.List;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem46 {

    private SieveOfEratosthenes sieve;
    
    public int solve() {
        final int MAX = 10000;
        sieve = new SieveOfEratosthenes(MAX);
        sieve.generate(true);
        
        List<Integer> primes = sieve.getPrimes();
        
        for (int n = 9; n < MAX; n += 2) {
            if (sieve.isPrime(n))
                continue;
            
            for (int prime : primes) {
                if (prime > n) 
                    return n;
                
                if (isPerfectSquare((n - prime)/2))
                    break;
            }
        }
        return 0;
    }
    
    public boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        
        return sqrt * sqrt == x;
    }
    
    public static void main(String[] args) {
        int solution = new Problem46().solve();
        
        System.out.println("Solution: " + solution);
    }
}
