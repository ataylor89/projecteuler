package archived;

import java.util.List;

/**
 *
 * @author ataylor
 */
public interface LargePrimeFinder {
    
    public abstract long generate(boolean showRunningTime);
    
    public abstract boolean isPrime(long n);
    
    public abstract List<Long> getPrimes();
    
    public abstract List<Long> getPrimes(long howMany);
    
    public abstract List<Long> getPrimesUpTo(long upperBound);
}
