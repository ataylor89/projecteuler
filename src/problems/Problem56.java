package problems;

import java.math.BigInteger;

/**
 *
 * @author ataylor
 */
public class Problem56 {
    
    static int max;
    
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            BigInteger a = BigInteger.valueOf(i);
            for (int j = 1; j < 100; j++) {
                BigInteger b = a.pow(j);
                int sum = sumOfDigits(b);
                
                if (sum > max) 
                    max = sum;
            }
        }
        
        System.out.println(max);
    }
    
    private static int sumOfDigits(BigInteger n) {
        int sum = 0;
        
        String s = n.toString();
        for (int i = 0; i < s.length(); i++) {
            int x = Integer.parseInt(s.substring(i, i+1));
            sum += x;
        }
        
        return sum;
    }
}
