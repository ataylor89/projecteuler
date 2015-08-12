package problems.problem61;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

import static problems.problem61.Polygon.*;
import util.princeton.Digraph;

/**
 *
 * @author andrewtaylor
 */
public class Problem61 {
    
    public void solve() {
        List<FigurateNumber> TRI = getFourDigitNumbers(TRIANGLE, n -> n*(n+1)/2);
        List<FigurateNumber> SQU = getFourDigitNumbers(SQUARE, n -> n*n);
        List<FigurateNumber> PEN = getFourDigitNumbers(PENTAGON, n -> n*(3*n-1)/2);
        List<FigurateNumber> HEX = getFourDigitNumbers(HEXAGON, n -> n*(2*n-1));
        List<FigurateNumber> HEP = getFourDigitNumbers(HEPTAGON, n -> n*(5*n-3)/2);
        List<FigurateNumber> OCT = getFourDigitNumbers(OCTAGON, n -> n*(3*n-2));
        
        List<FigurateNumber> vertices = concat(TRI, SQU, PEN, HEX, HEP, OCT);
        Digraph graph = new Digraph(vertices.size());
    }
    
    private List<FigurateNumber> concat(List<FigurateNumber> ... lists) {
        List<FigurateNumber> concatenated = new ArrayList<>();
        
        for (List<FigurateNumber> lst : lists) 
            concatenated.addAll(lst);
        
        return concatenated;
    }
    
    private List<FigurateNumber> getFourDigitNumbers(Polygon p, IntUnaryOperator formula) {
        List<FigurateNumber> fourDigitNumbers = new ArrayList<>();
        
        for (int n=1;;n++) {
            int result = formula.applyAsInt(n);

            if (result < 1000)
                continue;

            if (result > 9999)
                break;

            fourDigitNumbers.add(new FigurateNumber(p, result));
        }
        
        System.out.println(p + ": " + fourDigitNumbers);
        
        return fourDigitNumbers;
    }
    
    private boolean isCyclic(FigurateNumber n1, FigurateNumber n2) {
        String s1 = n1.toString(), s2 = n2.toString();
        
        return s2.startsWith(lastTwoChars(s1));
    }
    
    private String lastTwoChars(String str) {
        return str.substring(Math.max(str.length() - 2, 0));
    }
    
    public static void main(String[] args) {
        new Problem61().solve();
    }
}
