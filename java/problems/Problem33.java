package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem33 {
    
    class Fraction {
        int num, denom;
        
        Fraction(int num, int denom) {
            this.num = num;
            this.denom = denom;
        }
        
        @Override
        public String toString() {
            return num + "/" + denom;
        }
        
        public boolean sameAs(Fraction g) {
            return num == g.num && denom == g.denom;
        }
        
        public void simplify() {
            for (int i = 2; i <= num; i++) {
                while (divides(i, num) && divides(i, denom)) {
                    num = num / i;
                    denom = denom / i;
                }
            }
        }
        
        private boolean divides(int divisor, int dividend) {
            return dividend % divisor == 0;
        }
        
        public Fraction times(Fraction g) {
            return new Fraction(num * g.num, denom * g.denom);
        }
    }
    
    List<Fraction> fractions = new ArrayList<Fraction>();
    
    public void solve() {
        for (int num = 10; num < 100; num++) {
            for (int denom = num + 1; denom < 100; denom++) {
                Fraction f = new Fraction(num, denom);
                if (isCurious(f)) {
                    fractions.add(f);
                }
            }
        }
        System.out.println(fractions);
        
        Fraction product = new Fraction(1,1);
        for (Fraction f : fractions) 
            product = product.times(f);
        
        product.simplify();
        System.out.println(product);
    }
    
    public boolean isCurious(Fraction f) {
        if (isTrivial(f))
            return false;
        
        Fraction g = cancel(f);
        if (g == null || f.sameAs(g))
            return false;
        
        return f.num * g.denom == g.num * f.denom;
    }
    
    private boolean isTrivial(Fraction f) {
        return (f.num % 10 == 0) && (f.denom % 10 == 0);
    }
    
    private Fraction cancel(Fraction f) {
        String num = String.valueOf(f.num);
        String denom = String.valueOf(f.denom);
        
        for (Character c : num.toCharArray()) {
            String s = c.toString();
            if (denom.contains(s)) {
                num = num.replaceFirst(s, "");
                denom = denom.replaceFirst(s, "");
            }
        }
        
        if (num.equals("") || denom.equals(""))
            return null;
        if (denom.equals("0"))
            return null;
        
        return new Fraction(Integer.parseInt(num), Integer.parseInt(denom));
    }
    
    public static void main(String[] args) {
        new Problem33().solve();
    }
}
