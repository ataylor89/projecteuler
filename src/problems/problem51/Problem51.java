package problems.problem51;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import problems.Library;

/**
 *
 * @author ataylor
 */
public class Problem51 {
    public static void main(String[] args) {
//        NumberFamily f = new NumberFamily(54321, 1, 2);
//        System.out.println(f + ": " + f.getMembers());
//        
//        NumberFamily f2 = new NumberFamily(123456, 0, 2);
//        System.out.println(f2 + ": " + f2.getMembers());
//        
//        NumberFamily f3 = new NumberFamily(7654321, 4, 5, 6);
//        System.out.println(f3 + ": " + f3.getMembers());
//        
//        NumberFamily f4 = new NumberFamily(1234, 0, 1, 2, 3);
//        System.out.println(f4 + ": " + f4.getMembers());
//        
//        System.out.println("\nCombinations of (1,2,3,4,5):");
//        System.out.println(Library.combinations("12345"));
        
//        List<List<Integer>> cbs = combinations(5);
//        assert(cbs.size() == Library.combinations("12345").size());
        
        int start = 56003;
        int size = 5;
        List<List<Integer>> combinations = combinations(size);
        Library.generatePrimes((int) Math.pow(10, size + 1) - 1);
        
        for (int i = start; ; i++) {
            if (numDigits(i) > size) {
                size++;
                combinations = combinations(size);
                Library.generatePrimes((int) Math.pow(10, size + 1) - 1);
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
        
        Set<String> y = Library.combinations(s);
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
