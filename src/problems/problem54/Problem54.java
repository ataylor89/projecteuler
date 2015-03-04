package problems.problem54;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import problems.problem54.hands.Factory;
import problems.problem54.hands.ComplexHand;

/**
 *
 * @author ataylor
 */
public class Problem54 {
    
    public static void main(String[] args) throws Exception {
        Score score = new Score();
        
        URL url = new URL("https://projecteuler.net/project/resources/p054_poker.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        
//        BufferedReader br = new BufferedReader(new FileReader(new File("src/problems/problem54/test.txt")));
        
        String line;
        while ((line = br.readLine()) != null) {
            SimpleHand h1 = new SimpleHand();
            SimpleHand h2 = new SimpleHand();
            
            String[] cards = line.split(" ");
            
            for (int i = 0; i < 5; i++) {
                Card card = Card.fromShorthand(cards[i]);
                h1.addCard(card);
            }
            
            for (int i = 5; i < 10; i++) {
                Card card = Card.fromShorthand(cards[i]);
                h2.addCard(card);
            }
            
            Result result = new Result(h1, h2);
            System.out.println(result + "\n");
            
            score.addResult(result);
        }
        
        System.out.println(score);
    }
}
