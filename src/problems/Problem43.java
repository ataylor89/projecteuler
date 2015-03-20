package problems;

import java.util.ArrayList;
import java.util.List;
import util.Sets;

/**
 *
 * @author ataylor
 */
public class Problem43 {
    
    public void solve() {
        List<Long> suchNumbers = new ArrayList<>();
        List<String> permutations = Sets.permutations("0123456789");
        
        Library.generatePrimes(1000);
        
        for (String p : permutations) {
            boolean hasProperty = true;
            
            for (int i = 1; i < 8; i++) {
                String substr = p.substring(i, i+3);
                Long subint = Long.parseLong(substr);
                
                if (subint % Library.getNthPrime(i) != 0) {
                    hasProperty = false;
                    break;
                }
            }
            if (hasProperty) {
                suchNumbers.add(Long.parseLong(p));
            }
        }
        
        System.out.println(suchNumbers);
        
        long sum = 0;
        for (long n : suchNumbers) 
            sum += n;
        System.out.println("Sum: " + sum);
    }
    
    public static void main(String[] args) {
        new Problem43().solve();
    }
}
