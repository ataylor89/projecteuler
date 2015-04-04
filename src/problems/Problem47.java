package problems;

import util.PrimeFactorization;

/**
 *
 * @author ataylor
 */
public class Problem47 {
    
    public void solve() {
        final int bound = 1000000;
        final int start = 2*3*5*7;
        
        PrimeFactorization[] pfs = new PrimeFactorization[] {
            new PrimeFactorization(start),
            new PrimeFactorization(start + 1),
            new PrimeFactorization(start + 2),
            new PrimeFactorization(start + 3)
        };
        
        for (int n = start; n < bound; n++) {
            if (count(pfs[0]) >= 4 
                    && count(pfs[1]) >= 4 
                    && count(pfs[2]) >= 4 
                    && count(pfs[3]) >= 4) {
                
                System.out.println("Solution: " + n);
                return;
            }
            shift(pfs);
        }
    }

    private int count(PrimeFactorization pf) {
        return pf.map().keySet().size();
    }
    
    private void shift(PrimeFactorization[] pfs) {
        pfs[0] = pfs[1];
        pfs[1] = pfs[2];
        pfs[2] = pfs[3];
        pfs[3] = new PrimeFactorization(pfs[3].value() + 1);
    }
    
    public static void main(String[] args) {
        new Problem47().solve();
    }
}
