package problems.problem61;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

import static problems.problem61.Polygon.*;

/**
 *
 * @author andrewtaylor
 */
public class Problem61 {
    
    public void solve() {
        List<PolygonNumber> TRI = getFourDigitNumbers(TRIANGLE, n -> n*(n+1)/2);
        List<PolygonNumber> SQU = getFourDigitNumbers(SQUARE, n -> n*n);
        List<PolygonNumber> PEN = getFourDigitNumbers(PENTAGON, n -> n*(3*n-1)/2);
        List<PolygonNumber> HEX = getFourDigitNumbers(HEXAGON, n -> n*(2*n-1));
        List<PolygonNumber> HEP = getFourDigitNumbers(HEPTAGON, n -> n*(5*n-3)/2);
        List<PolygonNumber> OCT = getFourDigitNumbers(OCTAGON, n -> n*(3*n-2));
    }
    
    private List<PolygonNumber> getFourDigitNumbers(Polygon p, IntUnaryOperator formula) {
        List<PolygonNumber> fourDigitNumbers = new ArrayList<>();
        
        for (int n=1;;n++) {
            int result = formula.applyAsInt(n);

            if (result < 1000)
                continue;

            if (result > 9999)
                break;

            fourDigitNumbers.add(new PolygonNumber(p, result));
        }
        
        System.out.println(p + ": " + fourDigitNumbers);
        
        return fourDigitNumbers;
    }
    
    public static void main(String[] args) {
        new Problem61().solve();
    }
}
