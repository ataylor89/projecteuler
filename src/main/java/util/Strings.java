package util;

import java.util.Arrays;

/**
 *
 * @author ataylor
 */
public class Strings {
    
    public static String alphabetize(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        
        return new String(arr);
    }
    
    public static String alphabetize(long l) {
        return alphabetize(String.valueOf(l));
    }
    
    public static String alphabetize(int i) {
        return alphabetize(String.valueOf(i));
    }
}
