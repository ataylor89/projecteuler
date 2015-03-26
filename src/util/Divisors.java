package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Divisors {
    private final long number;
    private List<Long> divisors;
    
    public Divisors(long number) {
        if (number < 1)
            throw new IllegalArgumentException("Number must be positive.");
        
        this.number = number;
        divisors = new ArrayList<>();
        
        generate();
    }
    
    private void generate() {
        divisors.add(1L);
        for (long m = 2; m * m < number; m++) {
            if (number % m == 0) {
                divisors.add(m);
                divisors.add(number/m);
            }
        }
        
        if (number > 1)
            divisors.add(number);
    }
    
    public List<Long> get() {
        return divisors;
    }
    
    public List<Long> proper() {
        int end = divisors.size() - 1;
        
        return divisors.subList(0, end);
    }
    
    public int count() {
        return divisors.size();
    }
    
    public long sum() {
        long sum = 0;
        for (long n : divisors)
            sum += n;
        
        return sum;
    }
    
    public long sumProper() {
        long sum = 0;
        for (int i = 0; i < divisors.size() - 1; i++)
            sum += divisors.get(i);
        
        return sum;
    }
}
