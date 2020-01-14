package problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem39 {
    
    class Solution {
        int a, b, c;
        
        Solution(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(Object o) {
            Solution s = (Solution) o;
            
            return c == s.c && (a == s.a || a == s.b);
        }
        
        @Override
        public int hashCode() {
            return a + b + c;
        }
    }
    
    public void solve() {
        int maxSolutions = 0, maxP = 0;
        
        for (int p = 12; p <= 1000; p++) {
            Set<Solution> sols = solutionsFor(p);
            int n = sols.size();
            
            if (n > maxSolutions) {
                maxSolutions = n;
                maxP = p;
            }
        }
        System.out.println("n: " + maxSolutions + "\tp: " + maxP);
    }
    
    public Set<Solution> solutionsFor(int p) {
        Set<Solution> set = new HashSet<>();
        
        for (int a = 1; a < p/2; a++) {
            for (int b = 1; b < p/2; b++) {
                int c = p - a - b;
                if (a * a + b * b == c * c) {
                    set.add(new Solution(a, b, c));
                }
            }
        }
        return set;
    }
    
    public static void main(String[] args) {
        new Problem39().solve();
    }
}
