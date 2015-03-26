package problems;

import java.math.BigInteger;

/**
 *
 * @author ataylor
 */
public class Problem25 {
    
    public void solve() {
        BigInteger[] T = new BigInteger[3];
        T[0] = BigInteger.ONE;
        T[1] = BigInteger.ONE;
        T[2] = T[1].add(T[0]);
        
        int index = 3;
        while (digits(T[2]) != 1000) {
            T[0] = T[1];
            T[1] = T[2];
            T[2] = T[0].add(T[1]);
            index++;
        }
        
        System.out.println("Term number: " + index);
    }
    
    private int digits(BigInteger n) {
        return n.toString().length();
    }
    
    public static void main(String[] args) {
        new Problem25().solve();
    }
}
