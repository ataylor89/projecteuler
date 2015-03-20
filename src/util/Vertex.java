package util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Vertex implements Comparable<Vertex> {

    private Set<Edge> edges;
    private Set<Vertex> neighbors;
    private Integer value;
    
    public Vertex(int value) {
        this.value = value;
        
        edges = new HashSet<>();
        neighbors = new HashSet<>();
    }

    public Integer value() {
        return value;
    }
    
    public void addEdge(Edge e) {
        edges.add(e);  
    }
    
    public void addNeighbor(Vertex v) {
        neighbors.add(v);
    }
    
    public Set<Vertex> neighbors() {
        return neighbors;
    }
    
    public int degree() {
        return neighbors.size();
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public int compareTo(Vertex o) {
        return value().compareTo(o.value());
    }
}
