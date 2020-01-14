package problems;

import java.util.Collections;
import java.util.List;
import util.Sets;

/**
 *
 * @author ataylor
 */
public class Problem24 {
    
    public void solve() {
        List<String> permutations = Sets.permutations("0123456789");
        Collections.sort(permutations);
        
        System.out.println(permutations.get(1000000 - 1));
    }
    
    public static void main(String[] args) {
        new Problem24().solve();
    }
}
