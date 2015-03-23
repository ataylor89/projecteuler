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
        divisors.add(number);
    }
    
    public List<Long> get() {
        return divisors;
    }
    
    public int number() {
        return divisors.size();
    }
}
