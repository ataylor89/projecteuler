package problems;

/**
 *
 * @author ataylor
 */
public class Problem01 {
    
    public void solve() {
        int sum = 0;
        
        for (int n = 3; n < 1000; n++) {
            if (n % 3 == 0 || n % 5 == 0)
                sum += n;
        }
        
        System.out.println(sum);
    }
    
    public static void main(String[] args) {
        new Problem01().solve();
    }
}
