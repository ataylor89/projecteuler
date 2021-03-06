package problems;

import util.PrimeFactorization;

/**
 *
 * @author ataylor
 */
public class Problem03 {
    
    public void solve(long n) {
        PrimeFactorization pf = new PrimeFactorization(n);
        System.out.println(pf);
    }
    
    public static void main(String[] args) {
        new Problem03().solve(600851475143L);
    }
}
