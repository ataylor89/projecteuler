package problems;

import java.util.HashMap;
import java.util.Map;
import util.PrimeFactorization;

/**
 *
 * @author ataylor
 */
public class Problem05 {
    
    public void solve() {
        Map<Long, Integer> answer = new HashMap<>();
        
        for (int n = 1; n <= 20; n++) {
            Map<Long, Integer> mapN = new PrimeFactorization(n).map(); 
            
            for (long prime : mapN.keySet()) {
                int exp1 = 0;
                int exp2 = mapN.get(prime);
                
                if (answer.containsKey(prime))
                    exp1 = answer.get(prime);
                
                if (exp2 > exp1)
                    answer.put(prime, exp2);
            }
        }
        
        PrimeFactorization solution = new PrimeFactorization(answer);
        System.out.println(solution);
        System.out.println(solution.value());
    }
    
    public static void main(String[] args) {
        new Problem05().solve();
    }
}
