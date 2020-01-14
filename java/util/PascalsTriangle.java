package util;

/**
 *
 * @author andrewtaylor
 */
public class PascalsTriangle {
    private long[][] triangle;
    
    public PascalsTriangle(int n) {
        assert n > 0;

        triangle = new long[n][n];
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 1;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) 
                    triangle[i][j] = 1;
                else
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }
    }
    
    public long[][] getTriangle() {
        return triangle;
    }
}
