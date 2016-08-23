package problems;

import java.math.BigInteger;
import util.RunningTime;

/**
 *
 * @author ataylor
 */
public class Problem63 {
    
    private BigInteger[] bigInts;
    
    public Problem63() {
        bigInts = new BigInteger[10];
        
        for (int i = 0; i < bigInts.length; i++)
            bigInts[i] = BigInteger.valueOf(i);
    }

    public void solve() {
        int count = 0;
        int n = 1, min = 1;
        
        while (min < 10) {
            BigInteger threshold = BigInteger.TEN.pow(n-1);
            
            for (int i = min; i <= 9; i++) {
                BigInteger nthPower = bigInts[i].pow(n);
                
                if (nthPower.compareTo(threshold) >= 0)
                    count++;
                else
                    min++;
            }
            n++;
        }
        
        System.out.println("# of solutions: " + count);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem63().solve();
        
        RunningTime.print(begin);
    }
}
