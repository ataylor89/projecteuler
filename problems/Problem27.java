package problems;

import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem27 {
    
    SieveOfEratosthenes sieve;
    
    public void solve() {
        sieve = new SieveOfEratosthenes(100000);
        sieve.generate(true);
        
        int maxValue = 0, bestA = 0, bestB = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = a+1; b < 1000; b++) {
                
                int value = f(a, b);
                if (value > maxValue) {
                    maxValue = value;
                    bestA = a;
                    bestB = b;
                }
            }
            int value = f(a, a);
            if (value > maxValue) {
                maxValue = value;
                bestA = a;
                bestB = a;
            }
        }
        
        System.out.printf("(%d, %d) => %d consecutive primes%n", bestA, bestB, maxValue);
        System.out.println("a*b = " + bestA*bestB);
    }
    
    public int f(int a, int b) {
        int consecutivePrimes = 0;
        
        for (int n = 0; ;n++) {
            int value = n*n + a*n + b;
            
            if (sieve.isPrime(value))
                consecutivePrimes++;
            else 
                break;
        }
        
        return consecutivePrimes;
    }
    
    public static void main(String[] args) {
        new Problem27().solve();
    }
}
