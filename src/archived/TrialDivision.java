package archived;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class TrialDivision {

    private int depth;
    private List<Integer> primes;
    
    public TrialDivision(int depth) {
        this.depth = depth;
        primes = new ArrayList<>();
    }
    
    private void addPrime(int n) {
        primes.add(n);
    }
    
    public long generate(boolean showRunningTime) {
        long begin = System.currentTimeMillis();
        
        addPrime(2);
        addPrime(3);
        
        for (int n = 4; n <= depth; n++) {
            boolean isPrime = true;
            
            for (int prime : primes) 
                if (n % prime == 0) 
                    isPrime = false;
            
            if (isPrime)
                addPrime(n);
        }
        
        long runningTime = System.currentTimeMillis() - begin;
        
        if (showRunningTime)
            System.out.println("Generated primes in " + runningTime + "ms");
        
        return runningTime;
    }
    
    public boolean isPrime(int n) {
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) == n)
                return true;
            if (primes.get(i) > n)
                return false;
        }
        return false;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public List<Integer> getPrimesUpTo(int n) {
        for (int i = 0; i < primes.size(); i++) {
            if (primes.get(i) >= n)
                return primes.subList(1, i + 1);
        }
        return primes;
    }

    public List<Integer> getPrimes(int howMany) {
        return primes.subList(1, howMany);
    }

    public int size() {
        return depth;
    }
}