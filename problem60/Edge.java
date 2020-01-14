package problems.problem60;

/**
 *
 * @author ataylor
 */
public class Edge implements Comparable<Edge> {
    
    private Vertex v1, v2;
    
    public Edge(Vertex v1, Vertex v2) {
        this.v1 = (v1.value() < v2.value() ? v1 : v2);
        this.v2 = (v1.value() < v2.value()) ? v2 : v1;
    }
    
    public Vertex v1() {
        return v1;
    }
    
    public Vertex v2() {
        return v2;
    }
    
    @Override
    public String toString() {
        return String.format("[%d, %d]", v1.value(), v2.value());
    }

    @Override
    public int compareTo(Edge other) {
        int c1 = v1().compareTo(other.v1());
        
        if (c1 != 0)
            return c1;
        
        return v2().compareTo(other.v2());
    }
}
