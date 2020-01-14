package problems.problem54;

import problems.problem54.hands.ComplexHand;
import problems.problem54.hands.Factory;

/**
 *
 * @author ataylor
 */
public class Result {
    
    int player1 = 0;
    int player2 = 0;
    
    private ComplexHand h1, h2;
    
    public Result(SimpleHand s1, SimpleHand s2) {
        this.h1 = Factory.getTypeOfHand(s1);
        this.h2 = Factory.getTypeOfHand(s2);
        
        if (h1.compareTo(h2) > 0) 
            player1 = 1;
        else if (h1.compareTo(h2) < 0) 
            player2 = 1;
    }
    
    @Override
    public String toString() {
        char sign;
        
        if (player1 > player2)
            sign = '>';
        else if (player1 < player2)
            sign = '<';
        else
            sign = '=';
        
        return h1.toString() + " " + sign + " " + h2.toString();
    }
}
