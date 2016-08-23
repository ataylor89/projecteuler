package problems;

/**
 *
 * @author ataylor
 */
public class Problem44 {
    
    private final int maxN = 10000;
    private boolean[] sieve;
    
    public Problem44() {
        sieve = new boolean[pentagonal(maxN) * 2];
    }
    
    public final int pentagonal(int n) {
        return n * (3 * n - 1) / 2;
    }
    
    public void fillSieve() {
        for (int n = 1; n < maxN; n++) {
            int Pn = pentagonal(n);
            sieve[Pn] = true;
        }
    }
    
    public boolean isPentagonal(int n) {
        return sieve[n];
    }
    
    public void solve() {
        fillSieve();
        
        int minD = 0;
        
        for (int i = 1; i < maxN; i++) {
            for (int j = i + 1; j <= maxN; j++) {
                int Pi = pentagonal(i);
                int Pj = pentagonal(j);
                
                if (isPentagonal(Pi + Pj) && isPentagonal(Pj - Pi)) {
                    System.out.println("Found a pair! (" + Pi + ", " + Pj + ")");
                    
                    if (minD == 0 || Pj - Pi < minD) {
                        minD = Pj - Pi;
                    }
                }
            }
        }
        
        System.out.println(minD);
    }
    
    public static void main(String[] args) {
        new Problem44().solve();
    }
}
