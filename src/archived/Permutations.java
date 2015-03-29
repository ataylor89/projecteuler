package archived;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Permutations {
    
    private String s;
    private List<String> permutations;
    
    public Permutations(String s) {
        this.s = s;
        permutations = new ArrayList<>();
        permutations("", s, permutations);
    }
    
    private void permutations(String prefix, String s, List<String> perms) {
        int N = s.length();
        if (N == 0) perms.add(prefix);
        else {
            for (int i = 0; i < N; i++)
               permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N), perms);
        }
    }
    
    public List<String> get() {
        return permutations;
    }
}
