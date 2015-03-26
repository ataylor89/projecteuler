package archived;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ataylor
 */
public class BinaryTree {
    
    private TreeNode root;
    
    public BinaryTree(String s) {
        int[][] numbers = parse(s);
        root = new TreeNode(null, numbers[0][0], numbers[0][0]);
        
        addChildren(root, numbers, 1, 0);
    }
    
    private void addChildren(TreeNode p, int[][] v, int row, int col) {
        if (row >= v.length)
            adjustWeights(p);
        
        else {
            int valueL = v[row][col];
            int valueR = v[row][col + 1];

            p.setLeft(new TreeNode(p, valueL, valueL + p.getWeight()));
            p.setRight(new TreeNode(p, valueR, valueR + p.getWeight()));

            addChildren(p.getLeft(), v, row+1, col);
            addChildren(p.getRight(), v, row+1, col+1);
        }
    }
    
    private int[][] parse(String s) {
        String[] rows = s.split("\\n");
        int max = rows[rows.length - 1].split(" ").length;
        
        int[][] numbers = new int[max][max];
        
        for (int i = 0; i < rows.length; i++) {
            String[] strvalues = rows[i].split(" ");
            
            for (int j = 0; j < strvalues.length; j++)
                numbers[i][j] = Integer.parseInt(strvalues[j]);
        }
        
        return numbers;
    }
    
    private void adjustWeights(TreeNode n) {
        long leafWeight = n.getWeight();
        
        while (n != root) {
            n = n.getParent();
            
            if (leafWeight > n.getWeight())
                n.setWeight(leafWeight);
        }
    }
    
    public List<TreeNode> maximalPath() {
        TreeNode cursor = root;
        List<TreeNode> path = new ArrayList<>();
        path.add(cursor);
        
        while (!cursor.isLeaf()) {
            TreeNode left = cursor.getLeft();
            TreeNode right = cursor.getRight();
            
            cursor = left.compareTo(right) > 0 ? left : right;
            path.add(cursor);
        }
        
        return path;
    }
}
