package util;

/**
 *
 * @author ataylor
 */
public class Node implements Comparable<Node> { 
    
    private int value;
    private Long weight;
    
    private Node left, right, parent;

    public Node() {}
    
    public Node(int value) {
        this.value = value;
    }
    
    public Node(int value, long weight) {
        this.value = value;
        this.weight = weight;
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }
    
    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node o) {
        return weight.compareTo(o.getWeight());
    }
}
