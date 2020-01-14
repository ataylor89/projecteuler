package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Sets;
import util.SieveOfEratosthenes;
import util.RunningTime;

/**
 *
 * @author ataylor
 */
public class Problem49 {
    
    private SieveOfEratosthenes sieve;
    private Set<List<Integer>> candidates, solutions;
    
    public Problem49() {
        sieve = new SieveOfEratosthenes(10000);
        sieve.generate(true);
        
        candidates = new HashSet<>();
        solutions = new HashSet<>();
    }
    
    public void solve() {
        for (Integer p : sieve.getPrimesBetween(1000, 9999)) {
            List<Integer> pp = primePermutations(p);
            
            if (pp.size() >= 3)
                candidates.add(pp);
        }
        
        for (List<Integer> cnd : candidates)
            search(cnd);
        
        System.out.println(solutions);
    }
    
    private List<Integer> primePermutations(Integer p) {
        List<Integer> primes = new ArrayList<>();
        
        for (Integer n : Sets.permuteDigits(p))
            if (sieve.isPrime(n))
                primes.add(n);
        
        Collections.sort(primes);
        return primes;
    }
    
    private void search(List<Integer> s) {
        Collections.sort(s);
        int length = s.size();
        
        for (int i=0; i < length; i++) 
            for (int j=i+1; j < length; j++) 
                for (int k=j+1; k < length; k++) 
                    if (isArithmeticSequence(s.get(i), s.get(j), s.get(k)))
                        solutions.add(Arrays.asList(s.get(i), s.get(j), s.get(k)));

    }
    
    private boolean isArithmeticSequence(int i, int j, int k) {
        return (j - i) == (k - j);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem49().solve();
        RunningTime.print(begin);
    }
}
