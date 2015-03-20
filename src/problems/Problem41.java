package problems;

import java.util.Collections;
import java.util.List;
import util.Sets;

/**
 *
 * @author ataylor
 */
public class Problem41 {
    
    public void solve() { 
        int max = 7654321;
        Library.generatePrimes(max);
        
        String s = "1234567";
        while (s.length() >= 2) {
            int x = Integer.parseInt(s);
            List<Integer> permutations = Sets.permutations(x);
            Collections.sort(permutations);
            
            for (int i = permutations.size() - 1; i >= 0; i--) {
                Integer p = permutations.get(i);
                if (Library.isPrime(p)) {
                    System.out.println(p);
                    return;
                }
            }
            s = s.substring(0, s.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        new Problem41().solve();
    }
}
