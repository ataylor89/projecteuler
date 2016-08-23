package problems;

/**
 *
 * @author ataylor
 */
public class Problem28 {
    
    final int LENGTH = 1001;
    final int CENTER = (LENGTH-1)/2;
    final int LAST_NUMBER = LENGTH * LENGTH;
    
    int[][] matrix = new int[LENGTH][LENGTH];
    int x = CENTER, y = CENTER;
    int step = 0;
    int n = 1;
    
    public void solve() {
        matrix[CENTER][CENTER] = 1;
        n++;
        
        while (step < LENGTH) {
            step++;
            stepRight();
            stepDown();
            step++;
            stepLeft();
            stepUp();
        }
        
//y        print();
        System.out.println("Sum of numbers on diagonals: " +
                getSumOfNumbersOnDiagonals());
    }
    
    private void stepRight() {
        for (int i = 0; i < step; i++) {
            if (n > LAST_NUMBER)
                return;
            x++;
            matrix[x][y] = n;
            n++;
        }
    }
    
    private void stepDown() {
        for (int i = 0; i < step; i++) {
            if (n > LAST_NUMBER) 
                return;
            y++;
            matrix[x][y] = n;
            n++;
        }
    }
    
    private void stepLeft() {
        for (int i = 0; i < step; i++) {
            if (n > LAST_NUMBER)
                return;
            x--;
            matrix[x][y] = n;
            n++;
        }
    }
    
    private void stepUp() {
        for (int i = 0; i < step; i++) {
            if (n > LAST_NUMBER)
                return;
            y--;
            matrix[x][y] = n;
            n++;
        }
    }
    
    public void print() {
        for (int yc = 0; yc < LENGTH; yc++) {
            for (int xc = 0; xc < LENGTH; xc++) {
                System.out.printf("%04d ", matrix[xc][yc]);
            }
            System.out.println();
        }
    }
    
    public int getSumOfNumbersOnDiagonals() {
        int sum = 0;
        
        for (int i = 0; i < LENGTH; i++) 
            sum += matrix[i][i];
        for (int j = 0; j < LENGTH; j++) 
            sum += matrix[LENGTH-1-j][j];
        
        sum -= matrix[CENTER][CENTER];
        return sum;
    }
    
    public static void main(String[] args) {
        new Problem28().solve();
    }
}
