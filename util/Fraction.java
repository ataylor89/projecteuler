package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class Fraction implements Comparable<Fraction> {
    
    private final int num, denom;
    private List<Character> decimal;
    
    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
        
        if (denom < 0) {
            num *= -1;
            denom *= -1;
        }
    }
    
    public int numerator() {
        return num;
    }
    
    public int denominator() {
        return denom;
    }
    
    public Fraction reduce() {
        int n = num, d = denom;
        
        for (int i = 2; i * i <= d; i++) {
            while (n%i == 0 && d%i == 0) {
                n /= i;
                d /= i;
            }
        }
        
        return new Fraction(n, d);
    }
    
    public List<Character> decimal() {
        if (decimal == null) {
            decimal = new ArrayList<>();

            int integer = num/denom;
            decimal.add(C(integer));

            boolean isWholeNumber = (num%denom == 0);
            if (!isWholeNumber) {
                decimal.add('.');

                if (integer == 0)
                    divide(num, denom, new HashMap<Integer, Integer>());
                else 
                    divide(num%denom, denom, new HashMap<Integer, Integer>());
            }
        }
        return decimal;
    }
    
    private void divide(int n, int d, Map<Integer, Integer> ops) {
        if (ops.containsKey(n)) {
            decimal.add(ops.get(n), '(');
            decimal.add(')');
            return;
        }
        
        ops.put(n, decimal.size());
        
        int quotient = n * 10 / d;
        int remainder = n * 10 % d;
        
        decimal.add(C(quotient));
        
        if (quotient == 0) 
            divide(n*10, d, ops);
        else if (remainder != 0)
            divide(remainder, d, ops);
    }
    
    private char C(int i) {
        return Character.forDigit(i, 10);
    }
    
    public int period() {
        int start = decimal().indexOf('(');
        
        if (start < 0)
            return 0;
        
        int end = decimal().indexOf(')');
        
        return end-start-1;
    }
    
    public static Fraction mediant(Fraction f, Fraction g) {
        int a = f.numerator(), b = f.denominator();
        int c = g.numerator(), d = g.denominator();
        
        return new Fraction(a+c, b+d);
    }
    
    public boolean isReduced() {
        return Numbers.coPrime(num, denom);
    } 
    
    public boolean isProper() {
        return Math.abs(num) < denom;
    }
    
    public boolean isPositive() {
        return num > 0 && denom > 0;
    }
    
    @Override
    public String toString() {
        return num + "/" + denom;
    }
    
    public String asDecimal() {
        String s = "";
        for (char c : decimal())
            s += c;
        
        return s;
    }

    @Override
    public int compareTo(Fraction f) {
        Integer left = num * f.denominator();
        Integer right = denom * f.numerator();
        
        return left.compareTo(right);
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fraction))
            return false;
        
        Fraction f = (Fraction) o;
        return this.compareTo(f) == 0;
    }

    @Override
    public int hashCode() {
        Double d = (double) num / (double) denom;
        
        return d.hashCode();
    }
}
