package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import util.RunningTime;

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
    
    public Problem62() {
        map = new HashMap<>();
    }
    
    public void solve(long X) {
       for (long n=1;;n++) {
            Long cube = n*n*n;
            String hash = sortDigits(cube);
            
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
    
    private String sortDigits(Long cube) {
        char[] arr = cube.toString().toCharArray();
        Arrays.sort(arr);
        
        return new String(arr);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem62().solve(5);
        RunningTime.print(begin);
    }
}
