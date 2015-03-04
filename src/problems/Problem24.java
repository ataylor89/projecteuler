package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem24 {
    public static void main(String[] args) {
        List<String> permutations = permutations("0123456789");
        Collections.sort(permutations);
        System.out.println(permutations.get(1000000 - 1));
    }
    
    /* 
     * Taken from http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html 
     * and slightly modified.
     */
    public static List<String> permutations(String s) { 
        List<String> permutations = new ArrayList<>();
        permutations("", s, permutations);
        return permutations;
    }
    
    private static void permutations(String prefix, String s, List<String> perms) {
        int N = s.length();
        if (N == 0) perms.add(prefix);
        else {
            for (int i = 0; i < N; i++)
               permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N), perms);
        }

    }
}
