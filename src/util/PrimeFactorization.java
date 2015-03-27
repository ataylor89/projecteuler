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
    
    private final long number;
    private Map<Long, Integer> primeFactors;
    
    public PrimeFactorization(long number) {
        this.number = number;
        primeFactors = new HashMap<>();
        
        for (long i = 2; i * i <= number; i++) {
            while (number % i == 0) {
                number /= i;
                add(i);
            }
        }
        
        if (number > 1)
            add(number);
    }
    
    public PrimeFactorization(Map<Long, Integer> map) {
        this.primeFactors = map;
        
        long n = 1;
        for (long prime : map.keySet())
            for (int i = 0; i < map.get(prime); i++)
                n *= prime;
        
        this.number = n;
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
    
    public long value() {
        return number;
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
