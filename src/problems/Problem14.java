package problems;

import util.CollatzSequence;

/**
 *
 * @author ataylor
 */
public class Problem14 {
    
    public void solve() {
        CollatzSequence longest = new CollatzSequence(1);
        
        for (int n = 2; n < 1000000; n++) {
            CollatzSequence seq = new CollatzSequence(n);
            
            if (seq.length() > longest.length())
                longest = seq;
            
            System.out.println(n);
        }
        
        System.out.println("Start: " + longest.get(0) + ", Length: " + longest.length());
    }
    
    public static void main(String[] args) {
        new Problem14().solve();
    }
    
}
