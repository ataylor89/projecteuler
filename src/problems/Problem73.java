package problems;

import util.FareySequence;
import util.Fraction;

/**
 *
 * @author ataylor
 */
public class Problem73 {
    
    public void solve() {
        int order = 12000;
        Fraction start = new Fraction(1,3);
        Fraction end = new Fraction(1,2);
        
        FareySequence seq = new FareySequence(order, start, end);
        System.out.println(seq.terms().size());
    }
    
    public static void main(String[] args) {  
        new Problem73().solve();
    }
}
