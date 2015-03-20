package problems;

import archived.Library;

/**
 *
 * @author ataylor
 */
public class Problem53 {
    public static void main(String[] args) {
        long[][] pascalsTriangle = Library.getPascalsTriangle(101);
        
        String out = "";
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= i; j++) {
                out += pascalsTriangle[i][j];
                
                if (j < i)
                    out += " ";
            }
            out += "\n";
        }
        
        System.out.println(out);
        
        int count = 0;
        
        for (int n = 0; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (pascalsTriangle[n][r] > 1000000 || pascalsTriangle[n][r] < 0) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
}
