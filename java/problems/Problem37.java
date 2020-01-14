package problems;
import util.Primes;

/**
 *
 * @author ataylor
 */
public class Problem37 {
   
    public void solve() {
        System.out.println("Finished filling sieve.");
        
        int[] primes = new int[11];
        int counter = 0, index = 5;
        
        while (counter < 11) {            
            int prime = Primes.getNthPrime(index);
            if (isTruncatable(prime)) {
                primes[counter] = prime;
                System.out.println(counter + ": " + primes[counter]);
                counter++;
            }
            index++;
        }
        
        int sum = 0;
        for (int p : primes) 
            sum += p;
        System.out.println(sum);
    }
    
    public static boolean isTruncatable(int prime) {
        String s = String.valueOf(prime);
        
        boolean isTruncatable = true;
        for (int i = 0; i < s.length(); i++) {
            Integer left = Integer.parseInt(s.substring(i));
            Integer right = Integer.parseInt(s.substring(0, s.length() - i));
            
            if (Primes.isPrime(left) || Primes.isPrime(right)) 
                isTruncatable = false;
        }
        return isTruncatable;
    }
    
    public static void main(String[] args) {
        new Problem37().solve();
    }
    
}
