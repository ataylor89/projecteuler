package problems;

import java.math.BigInteger;

/**
 *
 * @author ataylor
 */
public class Problem20 {
    
    public void solve() {
        BigInteger num = BigInteger.ONE;
        
        for (int m = 100; m > 0; m--)
            num = num.multiply(BigInteger.valueOf(m));
        
        String s = num.toString();
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += Integer.parseInt(s.substring(i, i+1));
        
        System.out.println("Sum of digits: " + sum);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem20().solve();
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
