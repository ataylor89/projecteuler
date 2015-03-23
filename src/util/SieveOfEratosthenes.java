package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class SieveOfEratosthenes {

    private boolean[] sieve;
    
    public SieveOfEratosthenes(int size) {
        sieve = new boolean[size];
    }
    
    public long generate(boolean showRunningTime) {
        long begin = System.currentTimeMillis();
        
        final int depth = sieve.length - 1;
        
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;
        int m = (int) Math.sqrt(depth);

        for (int i=2; i<=m; i++)
           if (sieve[i])
              for (int k=i*i; k>0 && k<=depth; k+=i)
                 sieve[k]=false;
        
        long runningTime = System.currentTimeMillis() - begin;
        
        if (showRunningTime)
            System.out.println("Generated primes in " + runningTime + "ms.");
        
        return runningTime;
    }
    
    public boolean isPrime(int n) {
        if (n < 0)
            return false;
        
        return sieve[n];
    }

    public List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<>();
        
        for (int i = 0; i < sieve.length; i++) 
            if (sieve[i])
                primes.add(i);
        
        return primes;
    }
    
    public List<Integer> getPrimes(int howMany) {
        List<Integer> primes = new ArrayList<>();
            
        for (int i = 0; i < sieve.length && primes.size() < howMany; i++) 
            if (sieve[i])
                primes.add(i);
        
        return primes;
    }
    
    public List<Integer> getPrimesUpTo(int cutoff) {
        List<Integer> subset = new ArrayList<>();
        
        for (int i = 0; i <= cutoff && i < sieve.length; i++) 
            if (sieve[i])
                subset.add(i);
        
        return subset;
    }

    public int size() {
        return sieve.length;
    }
}
