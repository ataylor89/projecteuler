package tests;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import util.PrimeNumberGraph;
import util.Vertex;

/**
 *
 * @author ataylor
 */
public class GraphTest {
    
    private PrimeNumberGraph graph;
    private int sizeOfGraph = 7000; // ten thousand
    
    @Before
    public void setUp() {
//        graph = new Graph();
//        graph.addEdge(1, 2);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 1);
//        graph.addEdge(1, 10);
//        graph.addEdge(1, 11);
//        graph.addEdge(1, 12);
//        graph.addEdge(2, 13);
//        graph.addEdge(2, 14);
//        graph.addEdge(2, 15);
//        graph.addEdge(1, 3);
//        graph.addEdge(2, 4);
        
        graph = new PrimeNumberGraph(sizeOfGraph);
        graph.generate(true);
    }
    
    @Test
    public void testGraph() {
        System.out.println("\n" + graph + "\n");
        
        List<Vertex> pool = graph.verticesOfDegreeAtLeast(4);
        
        int size = pool.size();
        System.out.println("Number of vertices with degree >= 4: " + size);
        
        Vertex max = pool.get(size - 1);
        System.out.printf("Vertex with greatest degree: %s (degree: %d)%n", max, max.degree());
    }
}