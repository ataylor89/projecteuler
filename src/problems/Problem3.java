package problems;

import util.PrimeFactorization;

/**
 *
 * @author ataylor
 */
public class Problem3 {
    
    public void solve(long n) {
        PrimeFactorization pf = new PrimeFactorization(n);
        pf.generate(true);
        
        System.out.println(pf);
    }
    
    public static void main(String[] args) {
        new Problem3().solve(600851475143L);
    }
}
