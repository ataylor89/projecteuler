package problems;

/**
 *
 * @author ataylor
 */
public class Problem06 {
    
    public void solve() {
        long squareOfSum = 0;
        for (int i = 1; i <= 100; i++) 
            squareOfSum += i;
        squareOfSum *= squareOfSum;
        
        long sumOfSquares = 0;
        for (int i = 1; i <= 100; i++)
            sumOfSquares += i * i;
        
        System.out.println(squareOfSum - sumOfSquares);
    }
    
    public static void main(String[] args) {
        new Problem06().solve();
    }
}
