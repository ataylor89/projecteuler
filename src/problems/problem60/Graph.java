package problems.problem60;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Graph {
    
    protected Map<Integer, Vertex> vertices;
    protected Set<Edge> edges;
    
    public Graph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }
    
    public List<Vertex> vertices() {
        List<Vertex> listView = new ArrayList<>(vertices.values());
        Collections.sort(listView);
        
        return listView;
    }
    
    public List<Edge> edges() {
        List<Edge> listView = new ArrayList<>(edges);
        Collections.sort(listView);
        
        return listView;
    }
    
    public int size() {
        return vertices().size();
    }

    public Vertex addOnce(int n) {
        if (!vertices.containsKey(n))
            vertices.put(n, new Vertex(n));
        
        return vertices.get(n);
    }
    
    public void addEdge(int n1, int n2) {
        Vertex v1 = addOnce(n1);
        Vertex v2 = addOnce(n2);
        
        Edge e = new Edge(v1, v2);
        edges.add(e);
        
        v1.addEdge(e);
        v1.addNeighbor(v2);
        v2.addEdge(e);
        v2.addNeighbor(v1);
    }
    
    public List<Vertex> verticesOfDegreeAtLeast(int degree) {
        List<Vertex> pool = new ArrayList<>();
        
        for (Vertex v : vertices.values()) 
            if (v.degree() >= 4)
                pool.add(v);
        
        Collections.sort(pool);
        return pool;
    }
    
    @Override
    public String toString() {
        return "Vertices: " + vertices() + "\nEdges: " + edges();
    }
}

