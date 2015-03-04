package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem50 {
    
    private boolean sieve[] = new boolean[1000000];
    
    public void solve() {
        fillSieve();
        
        List<Integer> primes = listOfPrimes(sieve);
        
        List<Integer> longest = new ArrayList<>();
        
        int solution = 0;
        
        for (int n = 0; n < primes.size(); n++) {
            int prime = primes.get(n);
            
            for (int j = 0; j < primes.size(); j++) {
                int sum = 0;
                
                for (int k = j; k < primes.size(); k++) {
                    sum += primes.get(k);
                    
                    if (sum == prime) {
                        List<Integer> l = primes.subList(j, k + 1);
                        
                        if (l.size() > longest.size()) {
                            longest = l;
                            solution = prime;
                        }
                    }
                    if (sum >= prime) 
                        break;
                } 
            }
        }
        
        System.out.println("Solution: " + solution);
        System.out.println("# of consecutive primes: " + longest.size());
        System.out.println(longest);
    }
    
    private List<Integer> listOfPrimes(boolean[] sieve) {
        List<Integer> lst = new ArrayList<>();
        
        for (int n = 2; n < sieve.length; n++) {
            if (sieve[n])
                lst.add(n);
        }
        
        return lst;
    }
    
    private void fillSieve() {
        sieve[2] = true;
        
        for (int n = 3; n < sieve.length; n++) {
            sieve[n] = true;
            
            for (int m = 2; m <= (int) Math.sqrt(n); m++) {
                if (n % m == 0) {
                    sieve[n] = false;
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Problem50().solve();
    }
}
