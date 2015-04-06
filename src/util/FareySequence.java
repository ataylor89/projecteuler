package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class FareySequence {
    
    private final int N;
    private final String errorMsg = "N must be a positive integer.";

    private List<Fraction> terms;
    
    public FareySequence(int N) {
        this.N = N;
        
        if (N < 1)
            throw new IllegalArgumentException(errorMsg);
        
        terms = new ArrayList<>();
        terms.add(new Fraction(0, 1));
        terms.add(new Fraction(1, 1));
        
        for (int n = 2; n <= N; n++) 
            nextOrder(n);
    }
    
    public FareySequence(int N, Fraction start, Fraction end) {
        this.N = N;
        
        if (N < 1)
            throw new IllegalArgumentException(errorMsg);
        
        terms = new ArrayList<>();
        terms.add(start);
        terms.add(end);
        
        for (int n = 2; n <= N; n++) 
            nextOrder(n);    
    }
    
    private void nextOrder(int n) {
        for (int i = 1; i < terms.size(); i++) {
            Fraction a = terms.get(i-1);
            Fraction b = terms.get(i);
            
            if (a.denominator() + b.denominator() <= n)
                terms.add(i, Fraction.mediant(a, b));
        }
    }
    
    public List<Fraction> terms() {
        return terms;
    }
}
