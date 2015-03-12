package tests;

import java.util.HashSet;
import java.util.Set;
import util.Combination;
import util.Permutation;

/**
 *
 * @author ataylor
 */
public class CombinationsTest {
    
    public static void main(String[] args) {
        Set<Combination> cmbs = new HashSet<>();
        
        cmbs.add(new Combination(1, 3, 5));
        cmbs.add(new Combination(3, 1, 5));
        cmbs.add(new Combination(1, 2, 5));
        cmbs.add(new Combination(5, 2, 1));
        
        System.out.println(cmbs);
        
        Set<Permutation> pmts = new HashSet<>();
        
        pmts.add(new Permutation(1, 3, 5));
        pmts.add(new Permutation(3, 1, 5));
        pmts.add(new Permutation(1, 2, 5));
        pmts.add(new Permutation(5, 2, 1));
        
        System.out.println(pmts);
    }
}
