package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem52 {
    public static void main(String[] args) {
        for (int x = 1; ; x++) {
            String y = sort(x);
            String y2 = sort(x*2);
            String y3 = sort(x*3);
            String y4 = sort(x*4);
            String y5 = sort(x*5);
            String y6 = sort(x*6);
            
            if (y.equals(y2)
                    && y.equals(y3) 
                    && y.equals(y4) 
                    && y.equals(y5)
                    && y.equals(y6)) {
                
                System.out.println("Answer: " + x);
                System.out.println("2x: " + x*2);
                System.out.println("3x: " + x*3);
                System.out.println("4x: " + x*4);
                System.out.println("5x: " + x*5);
                System.out.println("6x: " + x*6);
                break;
            }
        }
    }
    
    private static String sort(int x) {
        String s = String.valueOf(x);
        List<Integer> l = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            int digit = Integer.parseInt(s.substring(i, i+1));
            l.add(digit);
        }
        
        Collections.sort(l);
        String out = "";
        for (int i = 0; i < l.size(); i++) {
            out += l.get(i);
        }
        
        return out;
    }
}
