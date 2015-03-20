package problems;

import util.FibonacciSequence;

/**
 *
 * @author ataylor
 */
public class Problem2 {
    
    public void solve() {
        FibonacciSequence sequence = FibonacciSequence.upTo(4000000);
        
        long sum = 0;
        for (int term : sequence.terms())
            if (term % 2 == 0)
                sum += term;
        
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        new Problem2().solve();
    }
    
}
