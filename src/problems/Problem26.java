package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem26 {

    public static void main(String[] args) {
        System.out.println("1/3: " + find_cycle_length(1, 3, null));
        System.out.println("1/6: " + find_cycle_length(1, 6, null));
        System.out.println("1/7: " + find_cycle_length(1, 7, null));
        System.out.println("1/9: " + find_cycle_length(1, 9, null));
        
        int longest = 0;
        int longest_n = 0;
        for (int n = 2; n < 1000; n++) {
            int len = find_cycle_length(1, n, null);
            if (len > longest) {
                longest_n = n;
                longest = len;
            }
        }
        
        System.out.println("n: " + longest_n + " // cycle length: " + longest);
    }

    public static int find_cycle_length(int m, int n, List<Integer> L) {
        if (L == null)
            L = new ArrayList<>();
        
        if (n > m) 
            m *= 10;
        
        int remainder = m % n;
        if (remainder == 0) 
            return 0;
        
        int index = L.indexOf(remainder);
        if (index > -1) 
            return L.size() - index;
        
        L.add(remainder);
        return find_cycle_length(remainder, n, L);
    }
}
