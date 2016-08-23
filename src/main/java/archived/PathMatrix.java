package archived;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrewtaylor
 */
public class PathMatrix {
    
    private final boolean[][] adj;
    private final int exp;
    
    private final List<Path>[][] result;
    
    private PathMatrix(boolean[][] adj, int exp) {
        assert(isSquare(adj));
        
        this.adj = adj;
        this.exp = exp;
        
        int size = adj.length;
        result = new ArrayList[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = new ArrayList<>();
                
                if (exp == 1 && adj[i][j])
                    result[i][j].add(new Path(i, j));
            }
        }
    }
//    
//    public static PathMatrix construct(boolean[][] adj, int exp) {
//        PathMatrix base = new PathMatrix(adj, 1);
//        PathMatrix product = base;
//        
//        for (int i = 0; i < exp; i++) 
//            product = times(base, product);
//        
//        return product;
//        
//    }
//    
//    private static PathMatrix times(PathMatrix base, PathMatrix pow) {
//        PathMatrix result = new PathMatrix(base.adjacency(), base.degree() + pow.degree());
//    }
    
    private boolean isSquare(boolean[][] base) {
        return base[0].length == base.length;
    }
    
    public boolean[][] adjacency() {
        return adj;
    }
    
    public int degree() {
        return exp;
    }
}
