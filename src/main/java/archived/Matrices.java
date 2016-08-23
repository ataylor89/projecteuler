package archived;

/**
 *
 * @author andrewtaylor
 */
public class Matrices {
    
    public static int[][] multiply(int[][] A, int[][] B) {
        assert(A[0].length == B.length);
        
        int n = A.length, m = A[0].length, p = B[0].length;
        
        int[][] AB = new int[n][p];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                
                for (int k = 0; k < m; k++) 
                    sum += A[i][k] * B[k][j];
                
                AB[i][j] = sum;
            }
        }
        
        return AB;
    }
          
    public static int[][] pow(int[][] A, int n) {
        int[][] P = identity(A.length);
        
        for (int i = 0; i < n; i++) 
            P = multiply(P, A);
        
        return P;
    }
    
    public static int[][] identity(int n) {
        int[][] I = new int[n][n];
        
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (i == j)
                    I[i][j] = 1;
        
        return I;
    }
    
    public static int[][] asInt(boolean[][] A) {
        int n = A.length, m = A[0].length;
        
        int[][] B = new int[n][m];
        
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                if (A[i][j])
                    B[i][j] = 1;
        
        return B;
    }
    
    public static String toString(int[][] A) {
        int n = A.length, m = A[0].length;
        
        String s = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                if (j > 0)
                    s += " ";
                
                s += A[i][j];
            }
            s += "\n";
        }
        
        return s;
    }
    
    public static String toString(boolean[][] A) {
        int n = A.length, m = A[0].length;
        
        String s = "";
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                if (j > 0)
                    s += " ";
                
                s += A[i][j] ? "1" : "0";
            }
            s += "\n";
        }
        
        return s;
    }
}
