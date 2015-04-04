package util;

/**
 *
 * @author ataylor
 */
public class Numbers {
    
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
