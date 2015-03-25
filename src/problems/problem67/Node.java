package problems.problem67;

/**
 *
 * @author ataylor
 */
public class Node {
    private int value;
    private long maximalPath;
    
    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getMaximalPath() {
        return maximalPath;
    }

    public void setMaximalPath(long maximalPath) {
        this.maximalPath = maximalPath;
    }
    
    public boolean hasMaximalPath() {
        return maximalPath != 0;
    }
}
