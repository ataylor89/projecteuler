package problems;

import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;
import util.ContinuedFraction;

/**
 *
 * @author ataylor
 */
public class Problem65 {
    
    class EulersNumber extends ContinuedFraction {
        
        @Override
        public int getA(int n) {
            if (n == 0)
                return 2;
            
            if ((n - 2) % 3 != 0) 
                return 1;
            
            int j = (n - 2) / 3;
            return 2 * (j+1);
        }
        
        @Override
        public int getB(int n) {
            return 1;
        }
    }
    
    public void solve() {
        EulersNumber e = new EulersNumber();
        
        BigFraction term = e.evaluate(99);
        System.out.println(term);
        
        System.out.println("Sum of numerator's digits: " + sum(term.getNumerator()));
    }
    
    private int sum(BigInteger numerator) {
        String s = numerator.toString();
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
            sum += Integer.parseInt(s.substring(i, i+1));
        
        return sum;
    }
    
    public static void main(String[] args) {
        new Problem65().solve();
    }
}
