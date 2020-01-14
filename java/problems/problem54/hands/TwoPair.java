package problems.problem54.hands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;


/**
 *
 * @author ataylor
 */
public class TwoPair extends ComplexHand {

    List<Rank> ranks = new ArrayList<>();
    
    public TwoPair(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        Map<Rank, Integer> m = hand.getRankFrequency();
        
        int numPairs = 0;
        for (Rank r : m.keySet())  {
            if (m.get(r) == 2) {
                numPairs++;
                ranks.add(r);
            }
        }
        
        return numPairs == 2;
    }

    @Override
    public int getHandStrength() {
        Collections.sort(ranks);
        
        return Hands.TWO_PAIR.value + ranks.get(0).value + ranks.get(1).value * 10;
    }
    
    @Override
    public String toString() {
        return "Two pair. " + super.toString();
    }
}
