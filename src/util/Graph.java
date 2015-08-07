 package util;

import java.util.List;

/**
 *
 * @author andrewtaylor
 */
public interface Graph<T> {
    
    public void addEdge(T n1, T n2);
    
    public void removeEdge(T n1, T n2);
    
    public void hasEdge(T n1, T n2);
    
    public List<T> outEdges(T n);
    
    public List<T> inEdges(T n);
}
