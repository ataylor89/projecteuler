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
    
    public FibonacciSequence(int length) {
        sequence = new ArrayList<>();

        sequence.add(1);
        sequence.add(1);
        for (int i = 2; i < length; i++) 
            sequence.add(sequence.get(i-1) + sequence.get(i-2));
    }
    
    public static FibonacciSequence upTo(int upperBound) {
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
        if (n < 0)
            throw new IllegalArgumentException("Argument n cannot be negative.");
        
        return sequence.get(n);
    }
    
    public List<Integer> terms() {
        return sequence;
    }
    
    public int size() {
        return sequence.size();
    }
}