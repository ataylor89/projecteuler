package util;

/**
 *
 * @author ataylor
 */
public class Grid {
    
    private int[][] grid;
    
    public Grid(String s) {
        String[] rows = s.split("\\n");
        int numColumns = rows[0].split(" ").length;
        
        grid = new int[rows.length][numColumns];
        
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(" ");
            assert(columns.length == numColumns);
            
            for (int j = 0; j < numColumns; j++) {
                grid[i][j] = Integer.parseInt(columns[j]);
            }
        }
    }
    
    public int[][] get() {
        return grid;
    }
    
    @Override
    public String toString() {
        String s = "";
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++)
                s += (col > 0 ? " " : "") + String.format("%02d", grid[row][col]);
            
            s += "\n";
        }
        return s;
    }
}
