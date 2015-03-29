package problems;

import java.util.ArrayList;
import java.util.List;
import util.Permutations;

/**
 *
 * @author ataylor
 */
public class Problem43 {
    
    int[] primes = new int[] {2,3,5,7,11,13,17};
    
    public void solve() {
        List<String> permutations = filter(new Permutations("0123456789").get());
        
        List<Long> solutions = new ArrayList<>();
        
        for (String p : permutations) {
            boolean hasProperty = true;
            
            for (int n = 0; n < primes.length; n++) {
                int term = Integer.parseInt(p.substring(n+1, n+4));
                
                if (term % primes[n] != 0) {
                    hasProperty = false;
                    break;
                }
            }
            
            if (hasProperty)
                solutions.add(Long.parseLong(p));
        }
        System.out.println("Sum of all solutions: " + sum(solutions));
    }
    
    private long sum(List<Long> solutions) {
        long sum = 0;
        for (long s : solutions)
            sum += s;
        
        return sum;
    }
    
    private List<String> filter(List<String> permutations) {
        List<String> filtered = new ArrayList<>();
        
        for (String p : permutations)
            if (!p.startsWith("0"))
                filtered.add(p);
        
        return filtered;
    }
    
    public static void main(String[] args) {
        new Problem43().solve();
    }
}
