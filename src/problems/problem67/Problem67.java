package problems.problem67;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author ataylor
 */
public class Problem67 {
    
    public void solve(String s) {
        Node[][] triangle = parse(s);
        int len = triangle.length;
        
        for (int row = len - 2 - (len % 2); row >= 0; row -= 2)
            maximalPath(triangle, row, row/2);
        
        System.out.println("Maximal path: " + triangle[0][0].getMaximalPath());
    }
    
    private long maximalPath(Node[][] triangle, int row, int col) {
        long value = triangle[row][col].getValue();
        
        if (row >= triangle.length - 1)
            return value;
        
        if (!triangle[row][col].hasMaximalPath()) {
            long L = value + maximalPath(triangle, row+1, col);
            long R = value + maximalPath(triangle, row+1, col+1);
            
            triangle[row][col].setMaximalPath(L>R ? L : R);
        }
        return triangle[row][col].getMaximalPath();
    }

    private Node[][] parse(String s) {
        String[] rows = s.split("\\n");
        int max = rows[rows.length - 1].split(" ").length;
        
        Node[][] nodes = new Node[max][max];
        
        for (int i = 0; i < rows.length; i++) {
            String[] strvalues = rows[i].split(" ");
            
            for (int j = 0; j < strvalues.length; j++)
                nodes[i][j] = new Node(Integer.parseInt(strvalues[j]));
        }
        
        return nodes;
    }
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        String location = "https://projecteuler.net/project/resources/p067_triangle.txt";
        
        URL url = new URL(location);
        String s = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A").next();
        
        long begin = System.currentTimeMillis();
        
        new Problem67().solve(s);
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
    }
}
