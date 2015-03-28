package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class Fraction {
    
    private int num, denom;
    private List<Character> decimal;
    
    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
        this.decimal = new ArrayList<>();
        
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
    
    public int numerator() {
        return num;
    }
    
    public int denominator() {
        return denom;
    }
    
    public int cycleLength() {
        int start = decimal.indexOf('(');
        
        if (start < 0)
            return 0;
        
        int end = decimal.indexOf(')');
        
        return end-start-1;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (char c : decimal)
            s += c;
        
        return s;
    }
}
