package util;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.fraction.BigFraction;

/**
 *
 * @author ataylor
 */
public class SquareRoot extends ContinuedFraction {
    
    private final int N;
    
    private Integer firstTerm;
    private List<Integer> period;
    
    public SquareRoot(int n) {
        this.N = n;
        List<Integer> terms = new ArrayList<>();
        
        if (isPerfectSquare())
            terms.add((int) Math.sqrt(n));
        else
            generate(1, 0, 1, terms);
        
        firstTerm = terms.get(0);
        period = terms.subList(1, terms.size());
    }
    
    @Override
    public int getA(int n) {
        if (n == 0)
            return firstTerm;
        
        return period.get((n - 1) % period.size());
    }

    @Override
    public int getB(int n) {
        return 1;
    }
    
    public int period() {
        return period.size();
    }
    
    public List<Integer> getTerms() {
        List<Integer> terms = Arrays.asList(firstTerm);
        terms.addAll(period);
        
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
     * These parameters store the fraction (a*sqrt(N) + b)/c.
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
        if (period.isEmpty())
            return String.format("[%d]", firstTerm);
        
        String periodStr = "";
        for (int term : period)
            periodStr += (periodStr.equals("") ? term : ", " + term);
        
        return String.format("[%d; (%s)]", firstTerm, periodStr);
    }
}
