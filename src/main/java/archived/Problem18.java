package archived;

import java.util.Scanner;

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

    public static class Node {
        Node left, right;
        int value;
        
        @Override
        public String toString() {
            return String.format(" %02d ", value);
        }
    }
    
    public static void main(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        
        Scanner sc = new Scanner(s);
        
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
        
        long runningTime = System.currentTimeMillis() - begin;
        System.out.println("Execution time: " + runningTime + "ms.");
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
