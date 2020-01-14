package problems;

/**
 *
 * @author ataylor
 */
public class Problem48 {
    
    public void solve() {
        long sum = 0;
        long modulus = (long) Math.pow(10, 10);
        
        for (long i = 1; i <= 1000; i++) {
            long ith_term = mod_pow(i, i, modulus);
            sum = mod_sum(sum, ith_term, modulus);
        }
        
        System.out.println(sum);
    }
    
    public long mod_pow(long n, long power, long modulus) {
        long product = 1;
        
        for (long i = 0; i < power; i++) 
            product = (product % modulus) * n;
        
        return product;
    }
    
    public long mod_sum(long a, long b, long modulus) {
        return (a + b) % modulus;
    }
    
    public static void main(String[] args) {
        new Problem48().solve();
    }
}
