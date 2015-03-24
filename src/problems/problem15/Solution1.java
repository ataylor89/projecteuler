package problems.problem15;

import java.util.Arrays;

/**
 *
 * @author ataylor
 */
public class Solution1 {

    private long[] paths = new long[21];
    
    public void solve() {
        Arrays.fill(paths, 0);
        
        for (int size = 1; size <= 20; size++) 
            solve(size, 0, 0);
        
        System.out.println(paths[20]);
    }
    
    private void solve(int grid, int x, int y) {
        if (isFinished(grid, x, y))
            paths[grid] += 1;
        
        else if (isKnown(grid, x, y))
           paths[grid] += paths[grid-x];
        
        else {
            if (hasRight(grid, x, y))
                solve(grid, x+1, y);
            
            if (hasDown(grid, x, y))
                solve(grid, x, y+1);
        }
    }
    
    private boolean isFinished(int grid, int x, int y) {
        return x == grid && y == grid;
    }
    
    private boolean isKnown(int grid, int x, int y) {
        return (x == y) && (paths[grid-x] != 0);
    }
    
    private boolean hasRight(int grid, int x, int y) {
        return y <= grid && x < grid;
    }
    
    private boolean hasDown(int grid, int x, int y) {
        return x <= grid && y < grid;
    }
    
    public static void main(String[] args) {
        new Solution1().solve();
    }
}
