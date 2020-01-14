package util;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ataylor
 */
public class CollatzSequence {
    
    private List<Long> sequence;
    
    public CollatzSequence(long n) {
        sequence = new ArrayList<>();
        sequence.add(n);
        
        while (n != 1) {
            if (n % 2 == 0)
                sequence.add(n /= 2);
            else
                sequence.add((n = n * 3 + 1));
        }
    }
    
    public long get(int n) {
        return sequence.get(n);
    }
    
    public int length() {
        return sequence.size();
    }
    
    @Override
    public String toString() {
        return sequence.toString();
    }
}
