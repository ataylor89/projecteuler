package tests;

/**
 *
 * @author ataylor
 */
public class MatrixTest {
    
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        
        fill(matrix);
        print(matrix);
    }
    
    static void fill(int[][] matrix) {
        int counter = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = counter++;
            }
        }
    }
    
    static void print(int[][] matrix) {
       for (int i = 0; i < 3; i++) {
           for (int j = 0; j < 3; j++) {
               System.out.printf("%2d ", matrix[i][j]);
           }
           System.out.println();
       }
    }
}
