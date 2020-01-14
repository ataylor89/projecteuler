package problems;

import util.Fraction;

/**
 *
 * @author ataylor
 */
public class Problem71 {
    
    public void solve() {
        int order = (int) Math.pow(10, 6);
        
        Fraction left = new Fraction(2, 5);
        Fraction right = new Fraction(3, 7);
        
        while (left.denominator() + right.denominator() <= order)
            left = Fraction.mediant(left, right);
        
        System.out.println(left);
    }
    
    public static void main(String[] args) {
        new Problem71().solve();
    }
}
