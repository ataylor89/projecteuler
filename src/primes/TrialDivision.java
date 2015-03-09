package primes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class TrialDivision extends PrimeGenerator {

    private boolean[] sieve;
    private List<Integer> primes;
    
    public TrialDivision(int depth) {
        super(depth);
        
        sieve = new boolean[depth + 1];
        primes = new ArrayList<>();
    }
    
    private void setPrime(int n) {
        sieve[n] = true;
        primes.add(n);
    }
    
    @Override
    public void generate() {
        setPrime(2);
        setPrime(3);
        
        for (int n = 4; n <= depth; n++) {
            boolean isPrime = true;
            
            for (int prime : primes) 
                if (n % prime == 0) 
                    isPrime = false;
            
            if (isPrime)
                setPrime(n);
        }
    }
    
    @Override
    public boolean isPrime(int n) {
        return sieve[n];
    }

    @Override
    public int getNthPrime(int n) {
        return primes.get(n);
    }

    @Override
    public List<Integer> getPrimes() {
        return primes;
    }
}