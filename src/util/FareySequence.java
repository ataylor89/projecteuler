package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ataylor
 */
public class FareySequence {
    
    private final int N;
    private final static String errorMsg = "N must be a positive integer.";

    private List<Fraction> terms;
    
    private FareySequence(int N, List<Fraction> terms) {
        this.N = N;
        this.terms = terms;
    }
    
    public static FareySequence directly(int n) {
        int a = 0, b = 1, c = 1, d = n;
        
        List<Fraction> terms = new ArrayList<>();
        terms.add(new Fraction(a, b));
        
        while (c <= n) {
            int k = (n+b)/d;
            int p = k*c-a;
            int q = k*d-b;
            
            a = c; b = d; c = p; d = q;
            
            terms.add(new Fraction(a, b));
        }
        
        return new FareySequence(n, terms);
    }
    
    public static FareySequence recursively(int n) {
        if (n < 1)
            throw new IllegalArgumentException(errorMsg);
        
        List<Fraction> terms = new ArrayList<>();
        terms.add(new Fraction(0, 1));
        terms.add(new Fraction(1, 1));
        
        for (int m = 2; m <= n; m++) 
            nextOrder(n, terms);
        
        return new FareySequence(n, terms);
    }
    
    private static void nextOrder(int n, List<Fraction> terms) {
        for (int i = 1; i < terms.size(); i++) {
            Fraction a = terms.get(i-1);
            Fraction b = terms.get(i);
            
            if (a.denominator() + b.denominator() <= n) 
                terms.add(i++, Fraction.mediant(a, b));
        }
    }
    
    public List<Fraction> terms() {
        return terms;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FareySequence))
            return false;
        
        FareySequence s = (FareySequence) o;
        
        return terms().equals(s.terms());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.terms);
        return hash;
    }
    
    @Override
    public String toString() {
        return terms.toString();
    }
}
