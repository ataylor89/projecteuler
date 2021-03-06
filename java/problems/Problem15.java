package problems;

/**
 *
 * @author ataylor
 */
public class Problem15 {
    
    public static long solve(long[][] grid, int x, int y) {
        int end = grid.length-1;
        
        if (x > end || y > end)
            return 0;
        
        if (x == end && y == end)
            return 1;
        
        if (grid[x][y] != 0)
            return grid[x][y];
        
        grid[x][y] = solve(grid, x + 1, y) + solve(grid, x, y + 1);
        return grid[x][y];
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        long answer = solve(new long[21][21], 0, 0);
        System.out.println("Number of paths: " + answer);
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
