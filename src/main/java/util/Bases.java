package util;

import java.util.Arrays;

/**
 *
 * @author andrewtaylor
 */
public class Bases {
    
    public static char[] base2(int n) {
        if (n == 0)
            return new char[] {'0'};
        if (n < 0)
            return null;
        return base2(n, null);
    }
    
    private static char[] base2(int n, char[] binary) {
        if (n == 0)
            return binary;
        
        int m = n, pow = 0;
        while ((m /= 2) >= 1)
            pow++;
        
        if (binary == null) {
            binary = new char[pow + 1];
            Arrays.fill(binary, '0');
        }

        binary[binary.length - pow - 1] = '1';
        
        return base2(n - (int) Math.pow(2, pow), binary);
    }
}
