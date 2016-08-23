package archived;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewtaylor
 */
public class Path {

    private List<Integer> path;

    public Path() {
        path = new ArrayList<>();
    }
    
    public Path(int ... vertices) {
        this();
        
        for (int v : vertices)
            path.add(v);
    }
    
    public Path(List<Integer> vertices) {
        this();
        
        path.addAll(vertices);
    }
    
    /**
     * @return the path
     */
    public List<Integer> getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(List<Integer> path) {
        this.path = path;
    }
    
    public void add(int v) {
        path.add(v);
    }
    
    public int get(int i) {
        return path.get(i);
    }
    
    public int size() {
        return path.size();
    }
    
    public Path join(Path b) {
        // Assert that a's last element equals b's first element,
        // since we will be joining on this node.
        assert(get(size() - 1) == b.get(0));
        
        Path c = new Path(path);
        
        // Skip path b's 0th element.
        for (int i = 1; i < b.size(); i++) 
            c.add(b.get(i));
        
        return c;
    }
    
    @Override
    public String toString() {
        return path.toString();
    }
}
