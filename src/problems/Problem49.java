package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem49 {
    private boolean[] sieve = new boolean[10000];
    
    private void fillSieve() {
        sieve[2] = true;
        
        for (int n = 3; n < sieve.length; n++) {
            sieve[n] = true;
            
            for (int m = 2; m <= (int) Math.sqrt(n); m++) {
                if (n % m == 0) {
                    sieve[n] = false;
                    break;
                }
            }
        }
    }
    
    private List<Integer> getFourDigitPrimes() {
        List<Integer> lst = new ArrayList<>();
        
        for (int n = 1000; n < sieve.length; n++) 
            if (sieve[n])
                lst.add(n);
        
        return lst;
    }
    
    public void solve() {
        fillSieve();
        
        List<Integer> fourDigitPrimes = getFourDigitPrimes();
        
        System.out.println("There are " + fourDigitPrimes.size() + " four digit primes.");
        
        for (int prime : fourDigitPrimes) {
            Set<Integer> permutations = new HashSet<>(Library.permutations(prime));
            
            for (Integer x : new ArrayList<>(permutations)) { 
               if (x < 1000)
                   permutations.remove(x);
               else if (!sieve[x])
                   permutations.remove(x);
            }
            
            Set<List<Integer>> sequences = findArithmeticSequences(new ArrayList<>(permutations));
            
            if (!sequences.isEmpty()) {
                for (List<Integer> seq : sequences) {
                    System.out.println(seq);
                }
            }
        }
    }
    
    private Set<List<Integer>> findArithmeticSequences(List<Integer> lst) {
        Set<List<Integer>> sequences = new HashSet<>();
        
        if (lst.size() < 3)
            return sequences;
        
        for (int i = 0; i < lst.size() - 2; i++) {
            for (int j = i + 1; j < lst.size() - 1; j++) {
                for (int k = i + 2; k < lst.size(); k++) {
                    
                    if (lst.get(j) - lst.get(i) == lst.get(k) - lst.get(j)) {
                        List<Integer> seq = new ArrayList<>();
                        seq.add(lst.get(i));
                        seq.add(lst.get(j));
                        seq.add(lst.get(k));
                        Collections.sort(seq);
                        
                        sequences.add(seq);
                    }
                }
            }
        }
        
        return sequences;
    }
    
    public static void main(String[] args) {
        new Problem49().solve();
    }
}
