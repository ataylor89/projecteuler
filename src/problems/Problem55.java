package problems;

import archived.Library;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem55 {
    
    private static BigInteger reverseDigits(BigInteger n) {
        String s = n.toString();
        String r = new StringBuilder(s).reverse().toString();
        return new BigInteger(r);
    }
    
    private static boolean isLychrelNumber(int n) {
        BigInteger num = BigInteger.valueOf(n);
        
        for (int i = 0; i < 50; i++) {
            BigInteger reverse = reverseDigits(num);
            BigInteger sum = num.add(reverse);
            
            if (Library.isPalindrome(sum.toString()))
                return false;
            
            num = sum;
        }
        return true;
    }
    
    public static void main(String[] args) {
        List<Integer> lychrelNumbers = new ArrayList<>();
        
        for (int i = 1; i < 10000; i++) {
            try {
                if (isLychrelNumber(i))
                    lychrelNumbers.add(i);
            }
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        
        System.out.println(lychrelNumbers.size());
    }
}