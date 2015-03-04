package problems;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem31 {

    int[] coins = new int[] {1, 2, 5, 10, 20, 50, 100, 200};
    
    class Solution {
        Set<List<Integer>> combinations;

        Solution() {
            combinations = new HashSet<>();
        }

        void add(List<Integer> combination) {
            Collections.sort(combination);
            combinations.add(combination);
        }
    }
    
    Map<Integer, Solution> solutions = new HashMap<>();

    public void solve() {
        for (int i = 1; i <= 200; i ++) {
            Solution s = new Solution();
            solve(new ArrayList<Integer>(), 0, i, s);
            
            System.out.printf("Solved %d coins. N(%d) = %d%n", i, i, s.combinations.size());
            solutions.put(i, s);
        }
    }

    private void solve(List<Integer> combination, int sum, int target, Solution s) {
        if (sum == target) {
            s.add(combination);
            return;
        }
        
        int difference = target - sum;
        if (solutions.containsKey(difference)) {
            for (List<Integer> tail : solutions.get(difference).combinations) {
                s.add(combine(combination, tail));
            }
            return;
        }

        for (int value : coins) {
            if (sum + value <= target) {
                List<Integer> ncomb = new ArrayList<>(combination);
                ncomb.add(value);

                solve(ncomb, sum + value, target, s);
            }
        }
    }
    
    private List<Integer> combine(List<Integer> L1, List<Integer> L2) {
        List<Integer> L = new ArrayList<>();
        L.addAll(L1);
        L.addAll(L2);
        return L;
    }

    public static void main(String[] args) {
        new Problem31().solve();
    }
}
