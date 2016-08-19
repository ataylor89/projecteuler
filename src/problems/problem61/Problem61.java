package problems.problem61;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ataylor
 */
public class Problem61 {
    private Set<Node> nodes;
    private List<Node> cycle;
    
    public Problem61() {
        nodes = new HashSet<>();
    }
    
    public void solve() {
        for (Node n : nodes) {
            List<Node> path = new ArrayList<>();
            path.add(n);
            
            recurse(n, path);
        }
        
        if (cycle == null) {
            System.out.println("Failed to find solution.");
            return;
        }
        
        System.out.println("Solution: " + cycle);
        
        int sum = 0;
        for (Node n : cycle)
            sum += n.value();
        
        System.out.println("Sum: " + sum);
    }
    
    private void recurse(Node current, List<Node> path) {
        if (cycle != null)
            return;

        if (path.size() == 6) {
            System.out.println("Path: " + path);
            
            if (isCycle(path) && meetsConditions(path)) 
                cycle = path;
            
            return;
        }
        
        for (Node next : current.getEdges()) {
            List<Node> newPath = new ArrayList<>();
            
            newPath.addAll(path);
            newPath.add(next);
            
            recurse(next, newPath);
        }
    }
    
    private boolean isCycle(List<Node> path) {
        Node n = path.get(0);
        Node m = path.get(path.size() - 1);
        
        return m.last2digits().equals(n.first2digits());
    }
    
    private boolean meetsConditions(List<Node> cycle) {
        Set<Polygon> polygons = new HashSet<>();
        Collections.addAll(polygons, Polygon.values());
        
        for (Node n : cycle)
            polygons.remove(n.polygon());
        
        return polygons.isEmpty();
    }
    
    public void drawEdges() {
        for (Node node : nodes) {
            for (Node node2 : nodes) {
                if (node.value() == node2.value())
                    continue;
                
                if (node.polygon().equals(node2.polygon()))
                    continue;
                
                if (node.last2digits().equals(node2.first2digits()))
                    node.drawEdge(node2);
            }
        }
    }
    
    public void populate() {
        int tri = 0, squ, pen, hex, hep, oct;
        int lb = 1000, ub = 9999;
        
        for (int n=1; tri <= ub; n++) {
            tri = n * (n+1)/2;
            squ = n * n;
            pen = n * (3*n - 1)/2;
            hex = n * (2*n - 1);
            hep = n * (5*n - 3)/2;
            oct = n * (3*n - 2);
            
            if (fourDigits(tri))
                add(tri, Polygon.TRIANGLE);
            
            if (fourDigits(squ))
                add(squ, Polygon.SQUARE);
            
            if (fourDigits(pen))
                add(pen, Polygon.PENTAGON);
            
            if (fourDigits(hex))
                add(hex, Polygon.HEXAGON);
            
            if (fourDigits(hep))
                add(hep, Polygon.HEPTAGON);
            
            if (fourDigits(oct))
                add(oct, Polygon.OCTAGON);
        }
    }
    
    private void add(int value, Polygon p) {
        nodes.add(new Node(value, p));
    }
    
    private boolean fourDigits(int value) {
        return value >= 1000 && value <= 9999;
    }
    
    public static void main(String[] args) {
        Problem61 graph = new Problem61();
        graph.populate();
        graph.drawEdges();
        graph.solve();
    }
    
}
