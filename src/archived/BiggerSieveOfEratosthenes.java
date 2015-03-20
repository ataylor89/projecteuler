package archived;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class BiggerSieveOfEratosthenes implements LargePrimeFinder {

    private long depth;
    private BooleanArray64 sieve;
    
    public BiggerSieveOfEratosthenes(long size) {
        this.depth = size - 1;
        sieve = new BooleanArray64(size);
    }
    
    @Override
    public long generate(boolean showRunningTime) {
        long begin = System.currentTimeMillis();
        
        sieve.fill(true);
        sieve.set(0, false);
        sieve.set(1, false);
        long m = (long) Math.sqrt(depth);
        
        for (long i = 2; i <= m; i++) 
            if (sieve.get(i))
                for (long k = i*i; k>0 && k<=depth; k+=i)
                    sieve.set(k, false);
        
        long runningTime = System.currentTimeMillis() - begin;
        
        if (showRunningTime)
            System.out.println("Generated primes in " + runningTime + "ms.");
        
        return runningTime;
    }

    @Override
    public boolean isPrime(long n) {
        if (n > sieve.length() - 1)
            return false;
        
        return sieve.get(n);
    }

    @Override
    public List<Long> getPrimes() {
        List<Long> primes = new ArrayList<>();
        
        for (long i = 0; i < sieve.length(); i++) 
            if (sieve.get(i))
                primes.add(i);
        
        return primes;
    }

    @Override
    public List<Long> getPrimes(long howMany) {
        List<Long> primes = new ArrayList<>();
            
        for (long i = 0; i < sieve.length() && primes.size() < howMany; i++) 
            if (sieve.get(i))
                primes.add(i);
        
        return primes;
    }

    @Override
    public List<Long> getPrimesUpTo(long cutoff) {
        List<Long> subset = new ArrayList<>();
        
        for (long i = 0; i <= cutoff && i < sieve.length(); i++) 
            if (sieve.get(i))
                subset.add(i);
        
        return subset;
    }
    
    public static void main(String[] args) {
        LargePrimeFinder pf = new BiggerSieveOfEratosthenes(0xFFFFFFFFL);
        pf.generate(true);
        
        List<Long> primes = pf.getPrimes();
        System.out.println(primes.size());
    }
}
