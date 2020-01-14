package problems.problem61;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Node {
    
    private Integer value;
    private Polygon polygon;
    public Set<Node> edges;
    
    public Node(int value, Polygon polygon) {
        this.value = value;
        this.polygon = polygon;
        edges = new HashSet<>();
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node m = (Node) o;
            return value.equals(m.value()) && polygon.equals(m.polygon());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }
    
    public void drawEdge(Node n) {
        edges.add(n);
    }
    
    public Set<Node> getEdges() {
        return edges;
    }
    
    public boolean hasEdge(Node n) {
        return edges.contains(n);
    }
    
    public Integer value() {
        return value;
    }
    
    public Polygon polygon() {
        return polygon;
    }
    
    public String last2digits() {
        String s = value.toString();
        
        if (s.length() <= 2)
            return s;
        
        return s.substring(2);
    }
    
    public String first2digits() {
        String s = value.toString();
        
        if (s.length() <= 2)
            return s;
        
        return s.substring(0, 2);
    }
    
    @Override
    public String toString() {
        return value.toString() + "/" + polygon.toString();
    }
    
}
