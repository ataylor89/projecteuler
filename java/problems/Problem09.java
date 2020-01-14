package problems;

/**
 *
 * @author ataylor
 */
public class Problem09 {
    
    public void solve() {
        for (int a = 1; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                double d = Math.sqrt(a * a + b * b);
                
                if (d != Math.floor(d))
                    continue;
                
                int c = (int) d;
                
                if (a + b + c == 1000) {
                    System.out.printf("(%d,%d,%d) => %d%n", a, b, c, a*b*c);
                    return;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        new Problem09().solve();
    }
}
