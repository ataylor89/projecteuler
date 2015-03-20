/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archived;

import java.math.BigInteger;

/**
 *
 * @author ataylor
 */
public class Primes {
    
    public static boolean isPrime(long n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            double sqrtN = Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static boolean isProbablyPrime(long n, int certainty) {
        BigInteger p = BigInteger.valueOf(n);
        return p.isProbablePrime(certainty);
    }
    
}
