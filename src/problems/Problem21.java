package problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem21 {
    
    static Set<Integer> amicableNumbers = new HashSet<>();
    
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if (i == j) {
                    continue;
                }
                if (d(i) == j && d(j) == i) {
                    amicableNumbers.add(i);
                    amicableNumbers.add(j);
                }
            }
            if (i % 1000 == 0) {
                System.out.println("i: " + i);
                System.out.println(amicableNumbers);
                System.out.println("Cardinality: " + amicableNumbers.size() + "\n");
            }
        }
        int answer = 0;
        for (int num : amicableNumbers) {
            answer += num;
        }
        System.out.println("Sum of amicable numbers under 10000: " + answer);
    }
    
    public static int d(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
