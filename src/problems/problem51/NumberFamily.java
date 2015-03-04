package problems.problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import problems.Library;

/**
 *
 * @author ataylor
 */
public class NumberFamily {
    
    private Integer root;
    private Integer[] indices;
    private List<Integer> members;
    
    private String name;
    
    public NumberFamily(int root, Integer ... indices) {        
        this.root = root;
        
        Arrays.sort(indices);
        this.indices = indices;
        
        members = new ArrayList<>();
        generate();
    }
    
    private void generate() {   
        char c = (indices[0] == 0) ? '1' : '0';
        
        for (; c <= '9'; c++) {
            char[] str = String.valueOf(root).toCharArray();
            
            for (int index : indices) 
               str[index] = c;
            
            String s = new String(str);
            members.add(Integer.parseInt(s));
        }
        
        Collections.sort(members);
    }
    
    public Integer getSmallest() {
        return members.get(0);
    }
    
    public Integer getRootNumber() {
        return root;
    }
    
    public int getSize() {
        return members.size();
    }
    
    public List<Integer> getMembers() {
        return members;
    }
    
    @Override
    public String toString() {
        if (name == null) {
            char[] str = String.valueOf(root).toCharArray();

            for (int index : indices) 
                str[index] = '*';

            name = new String(str);
        }
        return name;
    }
    
    public int numberOfPrimes() {
        int numPrimes = 0;
        
        for (Integer member : members) 
            if (Library.isPrime(member))
                numPrimes++;
        
        return numPrimes;
    }
}
