package problems;
import java.util.ArrayList;
import java.util.List;
import static problems.Library.isPalindrome;
import static problems.Library.base2;
/**
 *
 * @author ataylor
 */
public class Problem36 {
    
    void solve() {
        int limit = 1000000;
        List<Integer> L = new ArrayList<>();
        
        for (int n = 1; n < limit; n++) {
            char[] base2 = Library.base2(n);
            String base10 = String.valueOf(n);
            
            if (isPalindrome(base10) && isPalindrome(base2)) 
                L.add(n);
        }
        
        System.out.println(L);
        int sum = 0;
        for (Integer n : L) 
            sum += n;
        System.out.println("Sum: " + sum);
    }
    
    void test(String s) {
        if (Library.isPalindrome(s)) 
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is NOT a palindrome");
    }
    
    public static void main(String[] args) {
        Problem36 p = new Problem36();
//        p.test("585");
//        p.test("hiih");
//        p.test("123");
//        p.test("ANNA");
//        p.test("543212345");
//        p.test("blahblah");
//        
//        for (int n = 0; n < 16; n++) 
//            System.out.println(base2(n));
        
        p.solve();
    }
}
