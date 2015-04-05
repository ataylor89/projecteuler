package util;

import java.util.Map;

/**
 *
 * @author ataylor
 */
public class Numbers {
    
    public static int phi(long n) {
       Map<Long, Integer> map = new PrimeFactorization(n).map();
       
       int product = 1;
       for (long p : map.keySet()) {
           int k = map.get(p);
           
           product *= (p - 1) * (long) Math.pow(p, k-1);
       }
       
       return product;
    }
    
    public static int digitalRoot(long n) {
        if (n % 10 == n)
            return (int) n;
        
        String s = String.valueOf(n);
        long sum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String digit = s.substring(i, i+1);
            
            // Casting out nines.
            if (digit.equals("9"))
                continue;
            
            sum += Integer.parseInt(digit);
        }
        
        return digitalRoot(sum);
    }
    
    public static boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static boolean isEven(long n) {
        return n % 2 == 0;
    }
    
    public static boolean isOdd(long n) {
        return n % 2 == 1;
    }
}
