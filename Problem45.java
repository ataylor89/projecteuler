package problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class Problem45 {
    
    private Map<Long, Long> tNumbers, pNumbers, hNumbers;
    
    public Problem45() {
        tNumbers = new HashMap<>();
        pNumbers = new HashMap<>();
        hNumbers = new HashMap<>();
    }
    
    public void solve() {
        generate(100000);
        long max = Collections.max(hNumbers.keySet());
        
        long n = 40756;
        while (n <= max) {
            if (tNumbers.containsKey(n) && pNumbers.containsKey(n) && hNumbers.containsKey(n)) {
                System.out.println("Solution: " + n);
                return;
            }
            n++;
        }
        System.out.println("No solution found.");
    }
    
    private void generate(long n) {
        System.out.println("Generating maps...");
        for (long i = 1; i <= n; i++) {
            tNumbers.put(T(i), i);
            pNumbers.put(P(i), i);
            hNumbers.put(H(i), i);
        }
        System.out.println("Finished generating maps.");
    }
    
    private long T(long n) {
        return n * (n+1) / 2;
    }
    
    private long P(long n) {
        return n * (3*n - 1) / 2;
    }
    
    private long H(long n) {
        return n * (2*n - 1);
    }
    
    public static void main(String[] args) {
        new Problem45().solve();
    }
}
