package problems;

import java.util.HashMap;
import java.util.Map;
import util.RunningTime;
import util.Strings;

/**
 *
 * @author ataylor
 */
public class Problem62 {
    
    class CubicPermutation {
        long lowestValue;
        int frequency;
        
        CubicPermutation(long lowestValue, int frequency) {
            this.lowestValue = lowestValue;
            this.frequency = frequency;
        }
    }
    
    private Map<String, CubicPermutation> map;

    public void solve(long X) {
       map = new HashMap<>(); 
        
       for (long n=1;;n++) {
            long cube = n*n*n;
            String hash = Strings.alphabetize(cube);
            
            count(hash, cube);
            
            if (map.get(hash).frequency == 5) {
                System.out.println("Solution: " + map.get(hash).lowestValue);
                break;
            }
        }
    }
    
    private void count(String hash, long cube) {
        if (!map.containsKey(hash))
            map.put(hash, new CubicPermutation(cube, 0));
        
        map.get(hash).frequency++;
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem62().solve(5);
        RunningTime.print(begin);
    }
}
