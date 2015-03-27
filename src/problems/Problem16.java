package problems;

import util.BigInteger;

/**
 *
 * @author ataylor
 */
public class Problem16 {
    
    public void solve() {
        String result = new BigInteger("2").pow(1000).toString();
        
        int sum = 0;
        for (int i = 0; i < result.length(); i++) {
            int digit = Integer.parseInt(result.substring(i, i+1));
            sum += digit;
        }
        
        System.out.println("Sum of digits: " + sum);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem16().solve();
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
