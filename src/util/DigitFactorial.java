package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class DigitFactorial {
    
    private final int n;
    private List<Integer> terms;
    
    private static final Map<Integer, List<Integer>> loops;
    
    static {
        List[] A = new List[] {
            Arrays.asList(169, 363601, 1454),
            Arrays.asList(871, 45361),
            Arrays.asList(872, 45362)
        };
        
        loops = new HashMap<>();
        
        for (List loop : A)
            for (Object n : loop)
                loops.put((Integer) n, loop);
    }
    
    public DigitFactorial(int n) {
        this.n = n;
        assert(n >= 0);
        
        terms = new ArrayList<>();
        generate();
    }
    
    private void generate() {
        int m = n, s;

        while (!loops.containsKey(m)) {
            terms.add(m);
            
            if ((s = sumFactorial(m)) == m)
                break;
            
            m = s;
        }

        if (loops.containsKey(m)) 
            terms.addAll(loops.get(m));
    }
    
    private int sumFactorial(int n) {
        int sum = 0;
            
        for (int digit : Numbers.digits(n))
            sum += Numbers.factorial(digit);
        
        return sum;
    }
    
    public int length() {
        return terms.size();
    }
    
    public List<Integer> terms() {
        return terms;
    }
    
    @Override
    public String toString() {
        return terms.toString();
    }
}
