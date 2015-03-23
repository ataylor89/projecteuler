package problems;

import util.Divisors;

/**
 *
 * @author ataylor
 */
public class Problem12 {
    
    public void solve() {
        long T = 0;
        for (long i=1;;i++) {
            T += i;
            
            if (new Divisors(T).number() > 500)
                break;
        }
        System.out.println(T);
    }
    
    public static void main(String[] args) {
        new Problem12().solve();
    }
}
