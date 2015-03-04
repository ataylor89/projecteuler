package problems;

import java.util.Arrays;

/**
 *
 * @author ataylor
 */
public class Problem27 {
    
    static final PrimeFinder pf = new PrimeFinder();
    
    static {
        pf.fillSieve();
    }
    
    public static void main(String[] args) {
        int a = 0, b = 0;
        int numprimes = 0;

        for (int i = -1000; i < 1000; i++) {
            for (int j = -1000; j < 1000; j++) {
                int k = numPrimes(i, j);
                if (k  > numprimes) {
                    a = i;
                    b = j;
                    numprimes = k;
                }
            }
        }

        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("a*b: " + a * b);
        System.out.println("# of primes: " + numprimes);
    }

    static int numPrimes(int a, int b) {
        int numPrimes = 0;
        int n = 0;

        while (true) {
            int eval = n * n + a * n + b;
            if (pf.isPrime(eval)) {
                numPrimes++;
                n++;
                continue;
            }
            break;
        }        
        return numPrimes;
    }
    
    /** 
     * Taken from mkyong.com
     * http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
     */
    
    static class PrimeFinder {        
        // will contain true or false values for the first 10,000 integers
        boolean[] primes = new boolean[100000];

        //set up the primesieve
        public void fillSieve() {
            Arrays.fill(primes, true);        // assume all integers are prime.
            primes[0] = primes[1] = false;       // we know 0 and 1 are not prime.
            for (int i = 2; i < primes.length; i++) {
                //if the number is prime, 
                //then go through all its multiples and make their values false.
                if (primes[i]) {
                    for (int j = 2; i * j < primes.length; j++) {
                        primes[i * j] = false;
                    }
                }
            }
        }

        public boolean isPrime(int n) {
            if (n > 0) {
                return primes[n];
            }
            return false;
        }
    }
}
