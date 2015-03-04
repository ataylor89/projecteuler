package problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem23 {
    
    public static void main(String[] args) {
        final int UPPER_LIMIT = 28123;
        Set<Integer> abundantNumbers = new HashSet<>();
        
        System.out.println("Generating a set of abundant numbers...");
        for (int i = 1; i <= UPPER_LIMIT; i++) {
            if (isAbundant(i)) {
                abundantNumbers.add(i);
            }
        }
        
        int[] range = range(UPPER_LIMIT);
        
        System.out.println("Zeroing out the array...");
        for (Integer i : abundantNumbers) {
            for (Integer j : abundantNumbers) {
                int sum = i + j;
                if (sum < range.length) {
                    range[sum] = 0;
                }
            }
        }
        
        int answer = 0;
        for (int x : range) {
            answer += x;
        }
        System.out.println("Answer: " + answer);
    }
    
    public static boolean isAbundant(int n) {
        int sum = 0; 
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum > n ? true : false;
    }
    
    public static int[] range(int end) {
        int[] range = new int[end + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = i;
        }
        return range;
    }
}
