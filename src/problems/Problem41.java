package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import util.Permutations;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem41 {
    
    public void solve() { 
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(987654321 + 1);
        sieve.generate(true);
        
        String s = "123456789";
        while (s.length() >= 3) {
            List<Integer> permutations = asNumbers(new Permutations(s).get());
            Collections.sort(permutations);
            
            for (int i = permutations.size() - 1; i >= 0; i--) {
                int pandigital = permutations.get(i);
                
                if (sieve.isPrime(pandigital)) {
                    System.out.println("Largest pandigital prime: " + pandigital);
                    return;
                }
            }
            s = s.substring(0, s.length() - 1);
        }
    }
    
    private List<Integer> asNumbers(List<String> strings) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : strings)
            numbers.add(Integer.parseInt(s));
        
        return numbers;
    }
    
    public static void main(String[] args) {
        new Problem41().solve();
    }
}
