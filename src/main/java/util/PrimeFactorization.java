package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class PrimeFactorization {
    
    private final long value;
    private Map<Long, Integer> primeFactors;
    
    public PrimeFactorization(long N) {
        this.value = N;
        primeFactors = new HashMap<>();
        
        for (long i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                N /= i;
                addFactor(i, primeFactors);
            }
        }
        
        if (N > 1)
            addFactor(N, primeFactors);
    }
    
    public PrimeFactorization(Map<Long, Integer> map) {
        this.primeFactors = map;
        
        long N = 1;
        for (long prime : map.keySet())
            for (int i = 0; i < map.get(prime); i++)
                N *= prime;
        
        this.value = N;
    }
    
    public Map<Long, Integer> map() {
        return primeFactors;
    }
    
    public long value() {
        return value;
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
    
    private void addFactor(long p, Map<Long, Integer> m) {
        if (!m.containsKey(p))
            m.put(p, 0);
        
        int exponent = m.get(p);
        m.put(p, exponent + 1);
    }
}
