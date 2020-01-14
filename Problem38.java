package problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem38 {
    
    public void solve() {
        Set<Integer> pdNumbers = new HashSet<>();
        
        for (int i = 1; i < 10000; i++) {
            for (int j = 2; j <= 9; j++) {
                String s = compute(i, j);
                if (isPandigital(s))
                    pdNumbers.add(Integer.parseInt(s));
            }
        }
        System.out.println(Collections.max(pdNumbers));
    }
    
    public String compute(int x, int n) {
        String ret = "";
        for (int i = 1; i <= n; i++) {
            int product = x * i;
            ret += String.valueOf(product);
        }
        return ret;
    }
    
    public boolean isPandigital(String s) {
        if (s.length() != 9)
            return false;
        for (Integer i = 1; i <= 9; i++) 
            if (!s.contains(i.toString()))
                return false;
        return true;
    }
    
    public boolean isPandigital(Integer x) {
        return isPandigital(x.toString());
    }
    
    public static void main(String[] args) {
        new Problem38().solve();
    }
}
