package primes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class SieveOfEratosthenes extends PrimeGenerator {

    private boolean[] sieve;
    private List<Integer> primes;
    
    public SieveOfEratosthenes(int depth, boolean init) {
        super(depth);
        
        sieve = new boolean[depth + 1];
        
        if (init)
            generate();
    }
    
    @Override
    public void generate() {
        Arrays.fill(sieve,true);
        sieve[0]=false;
        sieve[1]=false;
        int m = (int) Math.sqrt(depth);

        for (int i=2; i<=m; i++)
           if (sieve[i])
              for (int k=i*i; k<=depth; k+=i)
                 sieve[k]=false;
    }
    
    @Override
    public boolean isPrime(int n) {
        return sieve[n];
    }

    @Override
    public int getNthPrime(int n) {
        return getPrimes().get(n);
    }

    @Override
    public List<Integer> getPrimes() {
        if (primes == null) {
            primes = new ArrayList<>();
            
            for (int i = 0; i < sieve.length; i++) 
                if (sieve[i])
                    primes.add(i);
        }
        return primes;
    }
}
