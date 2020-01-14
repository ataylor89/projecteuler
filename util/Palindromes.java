package util;

/**
 *
 * @author andrewtaylor
 */
public class Palindromes {
    
    public static boolean isPalindrome(int n) {
        return isPalindrome(String.valueOf(n));
    }
    
    public static boolean isPalindrome(long l) {
        return isPalindrome(String.valueOf(l));
    }
    
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) 
            if (s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        return true;
    }
    
    public static boolean isPalindrome(char[] c) {
        return isPalindrome(new String(c));
    }
}
