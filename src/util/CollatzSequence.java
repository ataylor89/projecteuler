package util;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author ataylor
 */
public class CollatzSequence {
    
    private List<Integer> sequence;
    
    public CollatzSequence(int start) {
        sequence = new ArrayList<>();
        
        sequence.add(start);
        int i = 0;
        
        int n;
        while ((n = sequence.get(i)) != 1) {
            if (n % 2 == 0)
                sequence.add(n/2);
            else
                sequence.add(n*3 + 1);
            i++;
        }
    }
    
    public int get(int n) {
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
