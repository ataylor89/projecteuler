package problems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem34 {
    final static int MAX = 2540160;
    static List<Integer> numbers = new ArrayList<>();
    
    public static void main(String[] args) {
        for (int n = 10; n < MAX; n++) {
            int sum = 0;
            for (int digit : digits(n)) 
                sum += factorial(digit);
            if (n == sum) 
                numbers.add(n);
        }
        System.out.println(numbers.size() + " such numbers.");
        int sum = 0;
        for (int n : numbers)
            sum += n;
        System.out.println("Sum of all such numbers: " + sum);
    }
    
    static int factorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
    
    static int[] digits(int n) {
        String str = String.valueOf(n);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = Integer.valueOf(str.substring(i, i+1));
        }
        return digits;
    }
}
