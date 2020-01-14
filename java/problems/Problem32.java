package problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Sets;

/**
 *
 * @author ataylor
 */
public class Problem32 {

    Set<Integer> products = new HashSet<>();

    public void solve() {
        List<String> permutations = Sets.permutations("123456789");
        int m1, m2, product;
        
        for (String number : permutations) {
            // Case 1:
            m1 = parse(number, 0, 1);
            m2 = parse(number, 1, 5);
            product = parse(number, 5);
            check(m1, m2, product);
            
            // Case 2:
            m1 = parse(number, 0, 2);
            m2 = parse(number, 2, 5);
            product = parse(number, 5);
            check(m1, m2, product);
            
            // Case 3:
            m1 = parse(number, 0, 3);
            m2 = parse(number, 3, 5);
            product = parse(number, 5);
            check(m1, m2, product);
            
            // Case 4:
            m1 = parse(number, 0, 4);
            m2 = parse(number, 4, 5);
            product = parse(number, 5);
            check(m1, m2, product);
        }
        
        int sum = 0;
        for (Integer n : products) 
            sum += n;
        System.out.println("Sum of pandigital products: " + sum);
    }

    public static void main(String[] args) {
        new Problem32().solve();
    }

    public static int parse(String s, int begin, int end) {
        return Integer.parseInt(s.substring(begin, end));
    }

    public static int parse(String s, int begin) {
        return Integer.parseInt(s.substring(begin));
    }

    public void check(int multiplicand, int multiplier, int product) {
        if (multiplicand * multiplier == product) {
            System.out.printf("%d * %d = %d%n", multiplicand, multiplier, product);
            products.add(product);
        }
    }
}
