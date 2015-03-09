package primes;

import java.util.List;

/**
 *
 * @author ataylor
 */
public abstract class PrimeGenerator {
    
    protected int depth;
    
    public PrimeGenerator(int depth) {
        this.depth = depth;
    }
    
    public int getDepth() {
        return depth;
    }
    
    public abstract void generate();
    
    public abstract boolean isPrime(int n);
    
    public abstract int getNthPrime(int n);
    
    public abstract List<Integer> getPrimes();
}
