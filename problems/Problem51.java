package problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import problems.problem51.NumberFamily;
import util.Sets;
import util.Primes;

/**
 *
 * @author ataylor
 */
public class Problem51 {
    public static void main(String[] args) {
        int start = 56003;
        int size = 5;
        List<List<Integer>> combinations = combinations(size);
        Primes.generatePrimes((int) Math.pow(10, size + 1) - 1);
        
        for (int i = start; ; i++) {
            if (numDigits(i) > size) {
                size++;
                combinations = combinations(size);
                Primes.generatePrimes((int) Math.pow(10, size + 1) - 1);
            }
            
            for (List<Integer> cb : combinations) {
                NumberFamily f = new NumberFamily(i, cb.toArray(new Integer[cb.size()]));
                if (f.numberOfPrimes() >= 8) {
                    System.out.println(f.getSmallest());
                }
            }
        }
    }
    
    private static List<List<Integer>> combinations(int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        
        String s = "";
        for (int i = 0; i < n; i++) 
            s += i;
        
        Set<String> y = Sets.combinations(s);
        for (String x : y) {
            List<Integer> cb = new ArrayList<>();
            
            for (int i = 0; i < x.length(); i++) {
                int digit = Integer.parseInt(x.substring(i, i+1));
                cb.add(digit);
            }
            
            combinations.add(cb);
        }
        return combinations;
    }
    
    private static int numDigits(int n) {
        return String.valueOf(n).length();
    }
}
