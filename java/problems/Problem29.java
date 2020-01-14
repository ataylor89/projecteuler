package problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem29 {
    public static void main(String[] args) {
        Set<Double> distinctTerms = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
               double d = Math.pow((double) a, (double) b);
               distinctTerms.add(d);
            }
        }
        System.out.println(distinctTerms.size());
    }
}
