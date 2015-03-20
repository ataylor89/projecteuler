package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author ataylor
 */
public class Clique implements Comparable<Clique> {
    
    private List<Vertex> vertices;
    
    public Clique() {
        vertices = new ArrayList<>();
    }
    
    public Clique(Vertex v) {
        this();
        vertices.add(v);
    }
    
    public Clique(Edge e) {
        this();
        vertices.add(e.v1());
        vertices.add(e.v2());
    }
    
    public Clique(Clique c, Vertex v) {
        this(v);
        vertices.addAll(c.vertices());
    }
    
    public boolean belongs(Vertex v) {
        return v.neighbors().containsAll(vertices);
    }
    
    public void add(Vertex v) {
        vertices.add(v);
        Collections.sort(vertices);
    }
    
    public List<Vertex> vertices() {
        return vertices;
    }
    
    public int size() {
        return vertices().size();
    }

    public Integer sum() {
        int sum = 0;
        
        for (Vertex v : vertices)
            sum += v.value();
        
        return sum;
    }
    
    @Override
    public int compareTo(Clique o) {
        return sum().compareTo(o.sum());
    }
    
    @Override
    public String toString() {
        return vertices.toString() + " => " + sum();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Clique) {
            Clique other = (Clique) obj;
            
            if (size() != other.size())
                return false;
            
            return vertices.containsAll(other.vertices());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return sum();
    }
}
