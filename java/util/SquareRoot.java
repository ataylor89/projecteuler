package util;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.fraction.BigFraction;

/**
 *
 * @author ataylor
 */
public class SquareRoot extends ContinuedFraction {
    
    private final int N;
    private List<Integer> terms;
    
    private final String errorMsg = "N must be a nonnegative integer.";
    
    public SquareRoot(int n) {
        this.N = n;
        
        if (N < 0)
            throw new IllegalArgumentException(errorMsg);
        
        terms = new ArrayList<>();
        
        if (isPerfectSquare())
            terms.add((int) Math.sqrt(n));
        else
            generate(1, 0, 1, terms);
    }
    
    @Override
    public int getA(int n) {
        if (n < terms.size())
            return terms.get(n);
        
        return terms.get((n - 1) % period() + 1);
    }

    @Override
    public int getB(int n) {
        return 1;
    }
    
    public int period() {
        return terms.size() - 1;
    }
    
    public List<Integer> terms() {
        return terms;
    }
    
    @Override
    public BigFraction evaluate(int iterations) {
        BigInteger[] p = new BigInteger[] {ZERO, ONE, null};
        BigInteger[] q = new BigInteger[] {ONE, ZERO, null};
        
        for (int n = 0; n <= iterations; n++) {
            BigInteger A = BigInteger.valueOf(getA(n));
            
            p[2] = A.multiply(p[1]).add(p[0]);
            q[2] = A.multiply(q[1]).add(q[0]);
            
            p[0] = p[1];
            p[1] = p[2];
            
            q[0] = q[1];
            q[1] = q[2];
        }
        
        return new BigFraction(p[2], q[2]);
    }
    
    /**
     * Generates the periodic continued fraction for sqrt(N).
     * 
     * The parameters store the expression (a*sqrt(N) + b)/c.
     * 
     * @param a the integer coefficient of sqrt(N)
     * @param b an integer
     * @param c an integer
     */
    private void generate(int a, int b, int c, List<Integer> terms) {
        // First, get the next term of the continued fraction.
        // This is simply the integer square root of the expression.
        int nextTerm = (a * (int) Math.sqrt(N) + b)/c;
        
        // Now we have to subtract this term from the expression
        b -= nextTerm * c;
        
        // To get the subsequent term, we take the reciprocal of our expression.
        // We then multiply numerator and denominator by a*sqrt(N) - b to get a new expression.
        int x, y, z;
        
        // The new expression will be (x + y)/z.
        //      x - the integer coefficient of sqrt(N)
        //      y - an integer
        //      z - an integer
        x = a*c;
        y = -1*b*c;
        z = a*a*N - b*b; 
        
        // Reduce the fraction (x+y)/z
        int[] reduced = reduce(x, y, z);
        x = reduced[0];
        y = reduced[1];
        z = reduced[2];
        
        terms.add(nextTerm);
        
        // Recursive stop condition.
        if (x == 1 && z == 1)
            terms.add(terms.get(0) + y);
        
        else 
            generate(x, y, z, terms);
    }
    
    private int[] reduce(int x, int y, int z) {
        // Check all factors up to (and including) the square root of z.
        for (int i = 2; i * i <= z; i++) {
            while (x%i==0 && y%i==0 && z%i==0) {
                x = x/i;
                y = y/i;
                z = z/i;
            }
        }
        
        // Check z.
        if (x%z==0 && y%z==0) {
            x = x/z;
            y = y/z;
            z = 1;
        }
        
        return new int[] {x, y, z};
    }
    
    private boolean isPerfectSquare() {
        double sqrt = Math.sqrt(N);
        return sqrt == Math.floor(sqrt);
    }
    
    @Override
    public String toString() {
        if (period() == 0)
            return terms.toString();
        
        String s = "";
        for (int i = 1; i < terms.size(); i++)
            s += (s.equals("") ? terms.get(i) : ", " + terms.get(i));
        
        return String.format("[%d; (%s)]", terms.get(0), s);
    }
}
