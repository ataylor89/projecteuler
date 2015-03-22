package problems;

import java.util.List;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem3 {
    
    public void solution1() {
        long n = 600851475143L;
        int m = (int) Math.sqrt(n);
        
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(m);
        sieve.generate(true);
        
        List<Integer> primes = sieve.getPrimes();
        
        for (int i = primes.size() - 1; i >= 0; i--) {
            int p = primes.get(i);
            
            if (n % p == 0) {
                System.out.println(p);
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        new Problem3().solution1();
    }
}
