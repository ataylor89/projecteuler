package problems;

import java.util.List;
import util.RunningTime;
import util.SieveOfEratosthenes;

/**
 *
 * @author ataylor
 */
public class Problem50 {
    
    public void solve() {
        SieveOfEratosthenes sieve = new SieveOfEratosthenes(1000000);
        sieve.generate(true);
        
        List<Integer> primes = sieve.getPrimesUpTo(1000000);
        
        int solution = 0, length = 0, index = 0;
        
        for (int i = 0; i < primes.size(); i++) {
            int runningSum = 0;
            for (int j = 0; i+j < primes.size(); j++) {
                runningSum += primes.get(i+j);
                
                if (runningSum >= 1000000)
                    break;
                
                if (sieve.isPrime(runningSum) && j > length) {
                    solution = runningSum;
                    length = j;
                    index = i;
                }
            }
        }
        
        System.out.println("Solution: " + solution);
        System.out.println("Length: " + length);
        System.out.println("Sequence: " + primes.subList(index, index+length));
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem50().solve();
        
        RunningTime.print(begin);
    }
}
