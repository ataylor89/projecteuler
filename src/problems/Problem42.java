package problems;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Problem42 {
    
    public void solve(List<String> words) {
        generate(1000);
        int numTriangleWords = 0;
        
        for (String word : words) {
            int value = valueOf(word);
            
            if (value > T.get(T.size() - 1)) 
                generate(value * 2);
            if (T.contains(value)) 
                numTriangleWords++;
        }
        
        System.out.println("# of triangle words: " + numTriangleWords);
    }
    
    private List<Integer> T;
    
    private void generate(int until) {        
        T = new ArrayList<>();
        
        int n = 1;
        while (T(n) <= until) 
            T.add(T(n++));
    }
    
    private int T(int n) {
        return n * (n+1) / 2;
    }
    
    private int valueOf(String word) {
        int value = 0;
        for (int i = 0; i < word.length(); i++) 
            value += word.charAt(i) - 'A' + 1;
        
        return value;
    }
    
    public static void main(String[] args) 
            throws Exception {
        
        String s = new String(Files.readAllBytes(Paths.get("words.txt")));
        List<String> words = new ArrayList<>();
        
        for (String w : s.split(",")) 
            words.add(w.replaceAll("\"", ""));
        
        new Problem42().solve(words);
    }
}
