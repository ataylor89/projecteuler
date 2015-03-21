package archived;

import java.util.List;

/**
 *
 * @author ataylor
 */
public interface PrimeSieve {
    
    public abstract long generate(boolean showRunningTime);
    
    public abstract boolean isPrime(int n);
    
    public abstract List<Integer> getPrimes();
    
    public abstract List<Integer> getPrimes(int howMany);
    
    public abstract List<Integer> getPrimesUpTo(int upperBound);
    
    public int size();
}
