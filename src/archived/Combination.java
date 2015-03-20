package archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class is immutable, like java.lang.String. 
 * 
 * @author ataylor
 */
public class Combination implements Comparable<Combination> {
    
    private final List<Integer> numbers;
    private Boolean hasProperty = null;
    
    /**
     * This creates an instance representing the empty set.
     */
    public Combination() {
        numbers = new ArrayList<>();
    }
    
    public Combination(Integer ... N) {
        this.numbers = Arrays.asList(N);
        Collections.sort(numbers);
    }
    
    public Combination(Combination existing, Integer ... N) {
        this();
        numbers.addAll(existing.getList());
        numbers.addAll(Arrays.asList(N));
        Collections.sort(numbers);
    }
    
    public Integer get(int i) {
        return numbers.get(i);
    }
    
    public List<Integer> getList() {
        return numbers;
    }
    
    public Integer size() {
        return numbers.size();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Combination))
            return false;
        
        Combination cmb = (Combination) o;
        
        if (size() != cmb.size())
            return false;
        
        for (int i = size() - 1; i >= 0; i--) 
            if (!get(i).equals(cmb.get(i)))
                return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        
        for (Integer n : numbers)
            hashCode += n.hashCode();
        
        return hashCode;
    }
    
    @Override
    public String toString() {
        return numbers.toString();
    }
    
//    public Set<Combination> pairs() {
//        Set<Combination> pairs = new HashSet<>();
//        
//        for (int i = 0; i < numbers.size(); i++) 
//           for (int j = i + 1; j < numbers.size(); j++) 
//               pairs.add(new Combination(numbers.get(i), numbers.get(j)));
//        
//        return pairs;
//    }
    
//    public Set<Combination> choose(int R) {
//        Set<Combination> S = new HashSet<>();
//        
//        if (R == size())
//            S.add(this);
//        else 
//            generate(new Combination(), numbers, S, R);
//        
//        return S;
//    }
    
//    private void generate(Combination subset, List<Integer> input, Set<Combination> S, final int R) {
//        if (input.size() > 0 && subset.size() < R) {
//            Integer n = input.get(0);
//            Combination subset2 = new Combination(subset, n);
//            
//            int end = input.size();
//            generate(subset2, input.subList(1, end), S, R);
//            generate(subset, input.subList(1, end), S, R);
//        }
//        else if (subset.size() == R) 
//            S.add(subset);
//    }

    public Integer sum() {
        Integer sum = 0;
        for (Integer n : numbers)
            sum += n;
        
        return sum;
    }
    
    @Override
    public int compareTo(Combination other) {
        return sum().compareTo(other.sum());
    }
}
