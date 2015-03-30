package util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Some of these methods were taken from:
 * http://introcs.cs.princeton.edu/java/23recursion/
 * 
 * @author ataylor
 */
public class Sets {
    
    public static Set<String> combinations(String s) { 
        return combinations("", s, new HashSet<String>()); 
    }

    private static Set<String> combinations(String prefix, String s, Set<String> S) {
        if (s.length() > 0) {
            S.add(prefix + s.charAt(0));
            combinations(prefix + s.charAt(0), s.substring(1), S);
            combinations(prefix,               s.substring(1), S);
        }
        return S;
    }
    
    public static List<Integer> permuteDigits(Integer number) {
        Set<Integer> permutations = new HashSet<>();
        
        for (String s : permutations(String.valueOf(number))) 
            if (!s.startsWith("0"))
                permutations.add(Integer.parseInt(s));
        
        return new ArrayList<>(permutations);
    }
    
    public static List<String> permutations(String s) { 
        List<String> permutations = new ArrayList<>();
        permutations("", s, permutations);
        
        return permutations;
    }
    
    private static void permutations(String prefix, String s, List<String> perms) {
        int N = s.length();
        
        if (N == 0) 
            perms.add(prefix);
        else 
            for (int i = 0; i < N; i++)
               permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N), perms);
    }
}
