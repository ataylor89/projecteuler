package problems.problem59;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class Message implements Comparable<Message> {
    private String key;
    private byte[] message_e, message_d;
    
    private int score = -1;
    
    private final byte[] VOWELS = new byte[] {'a', 'e', 'i', 'o', 'u'};
    
    private long sum = -1;
    
    public Message(String key, byte[] message) {
        this.key = key;
        this.message_e = message;
        
        decrypt();
    }
    
    public final byte[] decrypt() {
        if (message_d == null) {
            message_d = new byte[message_e.length];

            for (int i = 0; i < message_e.length; i++) {
                char operand = key.charAt(i % 3);
                message_d[i] = (byte) (message_e[i] ^ operand); 
            }
        }
        return message_d;
    }

    public Integer getScore() {
        if (score < 0) {
            List<Byte> lst = new ArrayList<>();
            
            for (byte b : message_d)
                lst.add(b);
            
            score = 0;
            for (byte vowel : VOWELS)
                score += Collections.frequency(lst, vowel);
        }
        return score;
    }
    
    public long getSum() {
        if (sum < 0) {
            sum = 0;
            for (byte b : message_d) 
                sum += b;
        }
        return sum;
    }
    
    @Override
    public int compareTo(Message m) {
        return getScore().compareTo(m.getScore());
    }
    
    @Override
    public String toString() {
        return String.format("Key: %s%nScore: %d%nDecoded: %s%nSum: %d%n", key, score, new String(message_d), getSum());
    }
}
