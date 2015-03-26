package problems;

import java.util.HashSet;
import java.util.Set;
import util.Divisors;

/**
 *
 * @author ataylor
 */
public class Problem21 {
    
    public void solve() {
        final int bound = 10000;
        
        Set<Integer> amicable = new HashSet<>();
        Divisors[] table = new Divisors[10000];
        
        for (int i = 1; i < table.length; i++)
            table[i] = new Divisors(i);
        
        for (int i = 1; i < bound; i++) {
            for (int j = i + 1; j < bound; j++) {
                Divisors di = table[i];
                Divisors dj = table[j];
                
                if (di.sumProper() == j && dj.sumProper() == i) {
                    amicable.add(i);
                    amicable.add(j);
                }
            }
        }

        System.out.println("Sum of amicable numbers under " + bound + ": " + sum(amicable));
    }
    
    public int sum(Set<Integer> set) {
        int sum = 0;
        for (int n : set)
            sum += n;
        
        return sum;
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem21().solve();
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
