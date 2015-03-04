package problems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class Problem17 {
    
    static final Map<Integer, String> numbers = new HashMap<>();
    
    static {  
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");
        numbers.put(100, "one hundred");
        numbers.put(200, "two hundred");
        numbers.put(300, "three hundred");
        numbers.put(400, "four hundred");
        numbers.put(500, "five hundred");
        numbers.put(600, "six hundred");
        numbers.put(700, "seven hundred");
        numbers.put(800, "eight hundred");
        numbers.put(900, "nine hundred");
        numbers.put(1000, "one thousand");
    }
    
    public static void main(String[] args) {
        for (int n = 21; n <= 1000; n++) 
            if (numbers.containsKey(n)) 
                continue;
            else
                numbers.put(n, spell(n));
        
        String result = "";
        for (int i = 1; i <= 1000; i++) {
            System.out.println(numbers.get(i));
            result += numbers.get(i);
        }
        
        String mini = minify(result);
        int len = mini.length();
        System.out.println("Number of letters: " + len);
    }
    
    public static String spell(int num) {
        String spelling = "";
        final int ND = numDigits(num);
        
        for (int i = 0; i < ND; i++) {
            int digit = getDigit(num, i);
            if (digit == 0)
                continue;
            
            int place = ND - i;
            int onesDigit, tensDigit;
            switch (place) {
                case 1:
                    tensDigit = getDigit(num, i-1);
                    if (tensDigit == 1)
                        continue;
                    if (tensDigit > 1)
                        spelling += "-";
                    spelling += numbers.get(digit);
                    break;
                case 2:
                    onesDigit = getDigit(num, i+1);
                    if (digit == 1) 
                        spelling += numbers.get(digit * 10 + onesDigit);
                    else 
                        spelling += numbers.get(digit * 10);
                    break;
                case 3:
                    spelling += numbers.get(digit * 100);
                    onesDigit = getDigit(num, i+2);
                    tensDigit = getDigit(num, i+1);
                    if (tensDigit + onesDigit > 0) 
                        spelling += " and ";
            }
        }
        return spelling;
    }
    
    public static int getDigit(int num, int i) {
        String str = String.valueOf(num).substring(i, i+1);
        return Integer.parseInt(str);
    }
    
    public static int numDigits(int num) {
        return String.valueOf(num).length();
    }
    
    public static String minify(String result) {
        return result.replaceAll(" ", "").replaceAll("-", "");
    }
}
