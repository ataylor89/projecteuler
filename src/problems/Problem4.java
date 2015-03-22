package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem4 {
    
    public void solve() {
        long begin = System.currentTimeMillis();
        
        List<Long> palindromes = new ArrayList<>();
        long product;
        
        for (long i = 111; i <= 999; i++) 
            for (long j = 111; j <= 999; j++) 
                if (isPalindrome(i * j))
                    palindromes.add(i * j);
        
        System.out.println(Collections.max(palindromes));
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms");
    }
    
    // Faster
    public boolean isPalindrome(Long n) {
        String s = n.toString();
        String t = reverse(s);
        
        return s.equals(t);
    }
    
    // Slower
    public boolean isPalindrome2(Long n) {
        Long n2 = Long.parseLong(reverse(n.toString()));
        
        return n.equals(n2);
    }
    
    private String reverse(String s) {
        return new StringBuilder(s.toString()).reverse().toString();
    }
    
    public static void main(String[] args) {
        new Problem4().solve();
    }
}
