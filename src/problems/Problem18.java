package problems;

/**
 *
 * @author ataylor
 */
public class Problem18 {
    
    static String s = 
        "75\n" +
        "95 64\n" +
        "17 47 82\n" +
        "18 35 87 10\n" +
        "20 04 82 47 65\n" +
        "19 01 23 75 03 34\n" +
        "88 02 77 73 07 63 67\n" +
        "99 65 04 28 06 16 70 92\n" +
        "41 41 26 56 83 40 80 70 33\n" +
        "41 48 72 33 47 32 37 16 94 29\n" +
        "53 71 44 65 25 43 91 52 97 51 14\n" +
        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
    
    public void solve(String s) {
        int[][] triangle = parse(s);
        
        System.out.println("Maximal path: " + maximalPath(triangle, 0, 0));
    }
    
    private long maximalPath(int[][] triangle, int row, int col) {
        long value = triangle[row][col];
        
        if (row >= triangle.length - 1)
            return value;
        
        long L = value + maximalPath(triangle, row+1, col);
        long R = value + maximalPath(triangle, row+1, col+1);
            
        return L > R ? L : R;
    }

    private int[][] parse(String s) {
        String[] rows = s.split("\\n");
        int max = rows[rows.length - 1].split(" ").length;
        
        int[][] triangle = new int[max][max];
        
        for (int i = 0; i < rows.length; i++) {
            String[] strvalues = rows[i].split(" ");
            
            for (int j = 0; j < strvalues.length; j++)
                triangle[i][j] = Integer.parseInt(strvalues[j]);
        }
        
        return triangle;
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem18().solve(s);
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
