package problems;

import java.util.List;
import util.FareySequence;
import util.Fraction;

/**
 *
 * @author ataylor
 */
public class Problem73 {
    
    public void solve() {
        FareySequence seq = FareySequence.directly(12000);
        List<Fraction> terms = seq.terms();
        
        int a = terms.indexOf(new Fraction(1,3));
        int b = (terms.size() - 1)/2;
        
        System.out.println("There are " + (b - a - 1) + " terms between 1/3 and 1/2.");
    }
    
    public static void main(String[] args) {  
        new Problem73().solve();
    }
}
