package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author andrewtaylor
 */
public class Primes {
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
    
    public static boolean[] getSieve() {
        return sieve;
    }
    
    public static List<Integer> getPrimes() {
        return primes;
    }
}
