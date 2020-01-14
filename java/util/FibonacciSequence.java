package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ataylor
 */
public class FibonacciSequence {
    
    private List<Integer> sequence;
    
    private FibonacciSequence(List<Integer> sequence) {
        this.sequence = sequence;
    }
    
    public static FibonacciSequence ofLength(int length) {
        if (length < 2)
            throw new IllegalArgumentException("Length should be >= 2.");
        
        List<Integer> sequence = new ArrayList<>();

        sequence.add(1);
        sequence.add(1);
        for (int i = 2; i < length; i++) 
            sequence.add(sequence.get(i-1) + sequence.get(i-2));
        
        return new FibonacciSequence(sequence);
    }
    
    public static FibonacciSequence upTo(int upperBound) {
        if (upperBound < 2)
            throw new IllegalArgumentException("Upper bound should be >= 2.");
        
        List<Integer> sequence = new ArrayList<>();

        sequence.add(1);
        sequence.add(1);
        int i = 2, nextTerm;
        
        while ((nextTerm = sequence.get(i-1) + sequence.get(i-2)) < upperBound) {
            sequence.add(nextTerm);
            i++;
        }
    
        return new FibonacciSequence(sequence);
    }
    
    public int get(int n) {
        return sequence.get(n);
    }
    
    public List<Integer> terms() {
        return sequence;
    }
    
    public int size() {
        return sequence.size();
    }
}
