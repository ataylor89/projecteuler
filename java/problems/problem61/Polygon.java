package problems.problem61;

/**
 *
 * @author ataylor
 */
public enum Polygon {
    TRIANGLE, 
    SQUARE, 
    PENTAGON, 
    HEXAGON, 
    HEPTAGON, 
    OCTAGON;
    
    @Override
    public String toString() {
        return super.toString().substring(0, 3);
    }
}
