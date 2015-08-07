package problems.problem61;

/**
 *
 * @author andrewtaylor
 */
public class PolygonNumber {
    Polygon polygon;
    int number;
    
    public PolygonNumber(Polygon p, int n) {
        polygon = p;
        number = n;
    }
    
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
