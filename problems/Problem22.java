package problems;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ataylor
 */
public class Problem22 {
    
    public static void main(String[] args) throws IOException {
        List<String> names = readFileAsList("src/problems/problem22/names.txt");
        Collections.sort(names);
        
        int sum = 0;
        for (int i = 0; i < names.size(); i++) {
            int score = getNameScore(names.get(i), i + 1);
            System.out.println(names.get(i) + ": " + score);
            sum += score;
        }
        
        System.out.println("Sum: " + sum);
    }
    
    public static int getNameScore(String name, int pos) {        
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            int val = name.charAt(i) - 'A' + 1;
            if (val < 1) {
                System.err.println("Invalid name: " + name);
                System.exit(1);
            }
            score += val;
        }
        return score * pos;
    }
    
    public static List<String> readFileAsList(String filename) throws IOException {
        List<String> names = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            String s = sc.next();
            s = s.replaceAll("\"", "");
            names.add(s.toUpperCase());
        }
        return names;
    }
}
