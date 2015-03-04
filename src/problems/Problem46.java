package problems;

/**
 *
 * @author ataylor
 */
public class Problem46 {
    
    private final int MAX = 10000;
    private boolean[] primeSieve;
    
    public Problem46() {
        primeSieve = new boolean[MAX+1];
        primeSieve[2] = true;
        primeSieve[3] = true;
    }
    
    private void fillSieve() {
        for (int n = 4; n <= MAX; n++) {
            // Assume it's prime
            primeSieve[n] = true;
            
            for (int m = 2; m < n; m++) {
                if (n % m == 0) {
                    primeSieve[n] = false;
                    break;
                }
            }
        }
    }
    
    public void solve() {
        fillSieve();
        
        for (int n = 9; n <= MAX; n += 2) {
            if (primeSieve[n])
                continue;
            if (!isGoldbachian(n)) {
                System.out.println(n);
                return;
            }
        }
    }
    
    public boolean isGoldbachian(int n) {
        for (int m = 2; m < n; m++) {
            if (!primeSieve[m])
                continue;
            int diff = n - m;
            if (diff % 2 != 0)
                continue;
            int x = diff / 2;
            if (isPerfectSquare(x)) 
                return true;
            
        }
        return false;   
    }
    
    public boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        if (sqrt * sqrt == x)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        new Problem46().solve();
    }
}
