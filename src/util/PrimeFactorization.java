package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class PrimeFactorization {
    
    private final long number;
    private Map<Long, Integer> primeFactors;
    
    public PrimeFactorization(long number) {
        this.number = number;
        primeFactors = new HashMap<>();
    }
    
    public long generate(boolean showRunningTime) {
        long begin = System.currentTimeMillis();
        
        long quotient = number;
        for (long i = 2; i <= number && quotient > 1; i++) {
            while (quotient % i == 0) {
                quotient /= i;
                add(i);
            }
        }
        
        long runningTime = System.currentTimeMillis() - begin;
        
        if (showRunningTime)
            System.out.printf("Factored %d in %d ms.%n", number, runningTime);
        
        return runningTime;
    }
    
    private void add(long p) {
        if (!primeFactors.containsKey(p))
            primeFactors.put(p, 0);
        
        int exponent = primeFactors.get(p);
        primeFactors.put(p, exponent + 1);
    }
    
    public Map<Long, Integer> get() {
        return primeFactors;
    }
    
    @Override
    public String toString() {
        String str = "";
        
        List<Long> lst = new ArrayList<>(primeFactors.keySet());
        Collections.sort(lst);
        
        for (long prime : lst) {
            int exp = primeFactors.get(prime);
            
            if (str.length() > 0)
                str += " * ";
            
            str += prime + ((exp > 1) ? "^" + exp : "");
        }
        return str;
    }
}