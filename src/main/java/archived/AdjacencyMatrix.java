package archived;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewtaylor
 */
public class AdjacencyMatrix<T> implements Graph<T> {

    private final BiMap<T, Integer> indexes = HashBiMap.create();
    private final boolean[][] adj;
    
    public AdjacencyMatrix(List<T> nodes) {
        int size = nodes.size();
        
        for (int i = 0; i < size; i++)
            indexes.put(nodes.get(i), i);
        
        adj = new boolean[size][size];
    }
    
    @Override
    public void addEdge(T from, T to) {
        int i = indexes.get(from);
        int j = indexes.get(to);
        
        adj[i][j] = true;
    }

    @Override
    public void removeEdge(T from, T to) {
        int i = indexes.get(from);
        int j = indexes.get(to);
        
        adj[i][j] = false;
    }

    @Override
    public boolean hasEdge(T from, T to) {
        int i = indexes.get(from);
        int j = indexes.get(to);
        
        return adj[i][j];
    }

    @Override
    public List<T> outEdges(T from) {
        List<T> outEdges = new ArrayList<>();
        
        final int i = indexes.get(from);
        
        BiMap<Integer, T> elements = indexes.inverse();
        
        for (int j = 0; j < adj[i].length; j++) 
            if (adj[i][j])
                outEdges.add(elements.get(j));
        
        return outEdges;
    }

    @Override
    public List<T> inEdges(T to) {
        List<T> inEdges = new ArrayList<>();
        
        final int j = indexes.get(to);
        
        BiMap<Integer, T> elements = indexes.inverse();
        
        for (int i = 0; i < adj.length; i++) 
            if (adj[i][j])
                inEdges.add(elements.get(i));
        
        return inEdges;   
    }
    
    public int[][] pow(int n) {
        return Matrices.pow(Matrices.asInt(adj), n);
    }
    
    @Override 
    public String toString() {
        return Matrices.toString(adj);
    }
}
