package problems.problem61;

import java.util.Objects;

/**
 *
 * @author andrewtaylor
 */
public class FigurateNumber {
    Polygon polygon;
    int number;
    
    public FigurateNumber(Polygon p, int n) {
        polygon = p;
        number = n;
    }
    
    @Override
    public String toString() {
        return String.valueOf(number);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FigurateNumber) {
            FigurateNumber p = (FigurateNumber) obj;
            
            return p.number == number && p.polygon == polygon;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.polygon);
        hash = 79 * hash + this.number;
        return hash;
    }
}
