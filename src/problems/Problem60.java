package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import util.Clique;
import util.Edge;
import util.PrimeNumberGraph;
import util.Vertex;

/**
 *
 * @author ataylor
 */
public class Problem60 {
    
    private PrimeNumberGraph graph;
    int sizeOfGraph = 3000;
    
    public Problem60() {
        graph = new PrimeNumberGraph(sizeOfGraph);
        graph.generate(true);
    }
    
    public void solve(int cliqueSize) {
        final int D = cliqueSize - 1;
        
        Set<Clique> origin = new HashSet<>();
        List<Vertex> pool = graph.verticesOfDegreeAtLeast(D);
        
        // This for loop will give us all relevant cliques size 2.
        for (Edge e : graph.edges())
            if (e.v1().degree() >= D && e.v2().degree() >= D)
                origin.add(new Clique(e));
        
        List<Clique> endpoint = generate(origin, 2, cliqueSize, pool);
        Collections.sort(endpoint);
        
        System.out.println("Solutions: " + endpoint);
    }
    
    private List<Clique> generate(Set<Clique> current, int currentSize, int targetSize, List<Vertex> pool) {
        if (currentSize >= targetSize) 
            return new ArrayList<>(current);
        
        Set<Clique> next = new HashSet<>();
        
        for (Vertex v : pool) 
            for (Clique c : current) 
                if (c.belongs(v))
                    next.add(new Clique(c, v));
        
        return generate(next, currentSize + 1, targetSize, pool);
    }
    
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        
        new Problem60().solve(5);
        clock(begin);
    }
    
    public static void clock(long beginTime) {
        System.out.println("Execution time : " + (System.currentTimeMillis() - beginTime) + "ms");
    }
}
