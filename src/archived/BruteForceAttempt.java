package archived;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.PrimeFinder;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class BruteForceAttempt {
    
    private List<Integer> primes;
    PrimeFinder pgen;
    
    private int minSum = 0;
    
    /**
     * It's important to remember that generating primes isn't the bottleneck.
     * As many as 20 million primes can be generated almost instantly.
     * 
     * The bottleneck is the solve() method, which will take as long as 10 hours
     * for testing primes up to 2,000.
     */
    public BruteForceAttempt() {
        int N = 20002000;
        
        pgen = new SieveOfEratosthenes(N);
        pgen.generate(true);
        primes = pgen.getPrimesUpTo(2000);
    }
    
    public void solve() {
        Set<Combination> S = new HashSet<>();
        check(new Combination(), primes, S, 5);
        
        if (S.size() > 0)
            System.out.println(Collections.min(S));
    }
    
    private void check(Combination cmb, List<Integer> input, Set<Combination> S, final int R) {
        if (input.size() > 0 && cmb.size() < R) {
            Integer n = input.get(0);
            if (tooLarge(n))
                return;
            
            Combination cmb2 = new Combination(cmb, n);
            
            int end = input.size();
            check(cmb2, input.subList(1, end), S, R);
            check(cmb, input.subList(1, end), S, R);
        }
        else if (cmb.size() == R && hasProperty(cmb))
            add(S, cmb);
    }
    
    private boolean hasProperty(Combination cmb) {
        for (int i = 0; i < cmb.size(); i++) {
           for (int j = i + 1; j < cmb.size(); j++) { 
               Integer n1 = concat2(cmb.get(i), cmb.get(j));
               Integer n2 = concat2(cmb.get(j), cmb.get(i));

               if (!pgen.isPrime(n1) || !pgen.isPrime(n2))
                   return false;
           }
        }
        return true;
    }
    
    private Integer concat1(Integer n1, Integer n2) {
        return Integer.parseInt(n1.toString() + n2.toString());
    }
    
    private Integer concat2(Integer n1, Integer n2) {
        int nd = n2.toString().length();
        
        for (int i = 0; i < nd; i++)
            n1 *= 10;
        
        return n1 + n2;
    }
    
    private void add(Set<Combination> S, Combination cmb) {
        S.add(cmb);
        int sum = cmb.sum();
        
        if (minSum == 0 || sum < minSum)
            minSum = sum;
    }
    
    private boolean tooLarge(int n) {
        if (minSum == 0)
            return false;
        
        return n + 2 + 3 + 5 + 7 > minSum;
    }
    
    public static void main(String[] args) {
        new BruteForceAttempt().solve();
    }
}
