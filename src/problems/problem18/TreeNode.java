package problems.problem18;

/**
 *
 * @author ataylor
 */
public class TreeNode implements Comparable<TreeNode> { 
    
    private Integer value;
    private Long weight;
    
    private TreeNode left, right, parent;
    
    public TreeNode(TreeNode parent, int value, long weight) {
        this.parent = parent;
        this.value = value;
        this.weight = weight;
    }
    
    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
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
    public int compareTo(TreeNode o) {
        return weight.compareTo(o.getWeight());
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}
