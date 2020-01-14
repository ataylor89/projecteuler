package problems;

import java.math.BigInteger;
import org.apache.commons.math3.fraction.BigFraction;
import util.ContinuedFraction;
import util.ContinuedFractions;

/**
 *
 * @author ataylor
 */
public class Problem65 {
    
    public void solve() {
        ContinuedFraction e = ContinuedFractions.eulersNumber;
        
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
