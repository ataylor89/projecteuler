package problems;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author ataylor
 */
public class Problem18 {
    
    public static class Node {
        Node left, right;
        int value;
        
        @Override
        public String toString() {
            return String.format(" %02d ", value);
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader("problem18.txt"));
        
        Node[] top = parse(sc.nextLine());
        Node root = top[0];
        while (sc.hasNextLine()) {
            Node[] bottom = parse(sc.nextLine());
            for (int i = 0; i < top.length; i++) {
                Node cursor = top[i];
                cursor.left = bottom[i];
                cursor.right = bottom[i+1];
            }
            top = bottom;
        }
        
        printTree(root);
        System.out.println("Max total: " + findMaxTotal(root));
    }
    
    public static Node[] parse(String line) {
        String[] numbers = line.split(" ");
        Node[] nodes = new Node[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            nodes[i] = new Node();
            nodes[i].value = Integer.parseInt(numbers[i]);
        }
        
        return nodes;
    }
    
    public static void printTree(Node root) {
        final int width = 60; 
        final int height = getDepth(root);
        
        Node[] top, bottom;
        top = new Node[]{root};
        
        for (int depth = 1; depth <= height; depth++) {
            String padding = getPadding(width, depth);
            System.out.println(padding + stringify(top) + padding);
            
            bottom = new Node[top.length+1];
            for (int j = 0; j < top.length; j++) {
                Node cursor = top[j];
                bottom[j] = cursor.left;
                bottom[j+1] = cursor.right;
            }
            top = bottom;
        }
    }
    
    public static int getDepth(Node root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
    
    public static String getPadding(int width, int depth) {
        int numSpaces = (width - depth * 4) / 2;
        
        String padding = "";
        for (int i = 0; i < numSpaces; i++) {
            padding += " ";
        }
        return padding;
    }
    
    public static String stringify(Node[] level) {
        String result = "";
        for (Node node : level) {
            result += node.toString();
        }
        return result;
    }
    
    public static int findMaxTotal(Node root) {
        return findMaxTotal(root, 0);
    }
    
    private static int findMaxTotal(Node leaf, int sum) {
        if (leaf == null)
            return sum;
        sum += leaf.value;
        
        int goLeft = findMaxTotal(leaf.left, sum);
        int goRight = findMaxTotal(leaf.right, sum);
        
        return goLeft > goRight ? goLeft : goRight;
    }
}
