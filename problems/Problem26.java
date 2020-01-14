package problems;

import util.Fraction;

/**
 *
 * @author ataylor
 */
public class Problem26 {

    public void solve() {
        Fraction max = new Fraction(0, 1);
        
        for (int n = 1; n < 1000; n++) {
            Fraction f = new Fraction(1, n);
            
            if (f.period() > max.period())
                max = f;
        }
        
        System.out.println(max);
        System.out.println("Answer: " + max.denominator());
    }
    
    public static void main(String[] args) {
        new Problem26().solve();
    }
}
