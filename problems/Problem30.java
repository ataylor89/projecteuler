package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem30 {
    
    static List<Integer> saved = new ArrayList<>();
    
    public static void main(String[] args) {
        for (int n = 2; n < 354295; n++) {
            String nstr = String.valueOf(n);
            int sumfifths = 0;
            
            for (int i = 0; i < nstr.length(); i++) {
                int digit = Character.getNumericValue(nstr.charAt(i));
                sumfifths += digit * digit * digit * digit * digit;
            }
            
            if (n == sumfifths) {
                saved.add(n);
            }
        }
        
        System.out.println(saved);
        
        int answer = 0;
        for (Integer x : saved) {
            answer += x;
        }
        
        System.out.println("Sum: " + answer);
    }
}
