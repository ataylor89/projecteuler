package problems;

import util.Primes;

/**
 *
 * @author ataylor
 */
public class Problem35 {

    public static void main(String[] args) {
        int max = 1000000;
        Primes.generatePrimes(max);
        
        System.out.println("Finished filling sieve");
        int count = 0;
        
        for (int i = 1; i < max; i++) {
            if (Primes.isCircularPrime(i)) {
                System.out.println(i + " is a circular prime " + Primes.rotations(i));
                count++;
            }
        }
        System.out.println(count);
    }
}
