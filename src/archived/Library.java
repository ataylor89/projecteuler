package archived;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Library {
    
    private static boolean[] sieve;
    private static List<Integer> primes;
    
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        
        generatePrimes(n);
        return sieve[n];
    }
    
    public static void generatePrimes(int n) {
        if (sieve != null && (sieve.length > n))
            return;
        
//        System.out.println("Generating primes up to " + n + "...");
        
        sieve = new boolean[n+1];
        sieve[2] = true;
        sieve[3] = true;

        primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        
        for (int i = 4; i <= n; i++) {
            boolean isPrime = true;
            
            for (int p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            sieve[i] = isPrime;
            if (isPrime)
                primes.add(i);
        }
        
//        System.out.println("Finished generating primes.");
    }

    public static int generateNthPrime(int n) {
        if (primes.size() >= n)
            return primes.get(n - 1);
        
        primes = new ArrayList<>();
        primes.add(2);
        primes.add(3);
        
        for (int i = 4; primes.size() < n; i++) {
            boolean isPrime = true;
            
            for (int p : primes) {
                if (i % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime)
                primes.add(i);
        }
        
        return primes.get(n - 1);
    }
    
    public static int getNthPrime(int n) {
        if (n < 1)
            throw new RuntimeException("Argument must be >= 1");
        
        generateNthPrime(n);
        return primes.get(n - 1);
    }
    
    public static void generatePrimesFromFile(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            String str = new String(encoded);
            
            String[] words = str.split("\\s+");
            int maxPrime = Integer.parseInt(words[words.length -1]);
            
            sieve = new boolean[maxPrime + 1];
            primes = new ArrayList<>();
            
            for (String word : words) {
                if (word == null || word.equals(""))
                    continue;
                    
                int prime = Integer.parseInt(word);
                
                sieve[prime] = true;
                primes.add(prime);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    public static boolean[] getSieve() {
        return sieve;
    }
    
    public static List<Integer> getPrimes() {
        return primes;
    }
    
    public static long[][] getPascalsTriangle(int n) {
        assert n > 0;
        
        long[][] PT = new long[n][n];
        PT[0][0] = 1;
        PT[1][0] = 1;
        PT[1][1] = 1;
        
        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) 
                    PT[i][j] = 1;
                else
                    PT[i][j] = PT[i-1][j-1] + PT[i-1][j];
            }
        }
        return PT;
    }
    
    /** Everything above this comment is good. 
     * Everything below is not so good. */
    
    public static boolean isCircularPrime(int n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 5)
            return true;
        if (String.valueOf(n).matches("[024568]"))
            return false;
        
        Set<Integer> rotations = rotations(n);
        int max = Collections.max(rotations);
        
        generatePrimes(max);
        
        boolean isCircularPrime = true;
        for (int x : rotations) 
            if (!isPrime(x)) 
                isCircularPrime = false;
        
        return isCircularPrime;
    }
    
    public static Set<Integer> rotations(int num) {
        Set<Integer> rotations = new HashSet<>();
        
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1, s.length()) + s.charAt(0);
            rotations.add(Integer.parseInt(s));
        }
        
        return rotations;
    }

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
    
    public static boolean isPandigital(String s) {
        if (s.length() != 9)
            return false;
        for (Integer i = 1; i <= 9; i++) 
            if (!s.contains(i.toString()))
                return false;
        return true;
    }
    
    public static boolean isPandigital(Integer x) {
        return isPandigital(x.toString());
    }
    
    public static boolean divides(int divisor, int dividend) {
        return dividend % divisor == 0;
    }
}
