package util;

import java.math.BigInteger;
import static util.Numbers.isEven;
import static util.Numbers.isOdd;

/**
 *
 * @author ataylor
 */
public class BigIntegers extends Numbers {
    
    public static int digitalRoot(BigInteger n) {
        if (n.toString().length() == 1)
            return n.intValue();
        
        String s = n.toString();
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
    
    public static boolean ruleOutPerfectSquare(BigInteger n) { 
        int digitalRoot = digitalRoot(n);
        int onesDigit = n.mod(BigInteger.TEN).intValue();
        int lastTwoDigits = n.mod(BigInteger.valueOf(100)).intValue();
        
        boolean isEven = isEven(n);
        
        return ruleOutPerfectSquare(digitalRoot, onesDigit, lastTwoDigits, isEven);
    }
    
    private static boolean ruleOutPerfectSquare(int digitalRoot, int onesDigit, int lastTwoDigits, boolean isEven) {
        if (onesDigit == 2 || onesDigit == 3 || onesDigit == 7 || onesDigit == 8)
            return true;
        
        if (digitalRoot != 1 && digitalRoot != 4 && digitalRoot != 7 && digitalRoot != 9)
            return true;
        
        if (onesDigit == 5 && lastTwoDigits != 25)
            return true;
        
        if (isEven && (lastTwoDigits % 4 != 0))
            return true;
         
        int tensDigit = lastTwoDigits / 10;
         
        if (onesDigit == 6 && isEven(tensDigit))
            return true;
        
        if (onesDigit != 6 && isOdd(tensDigit))
            return true;
        
        return false;
    }
    
    public static boolean isEven(BigInteger n) {
        return n.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO);
    }
}
