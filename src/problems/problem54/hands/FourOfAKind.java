package problems.problem54.hands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import problems.problem54.Card;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;

/**
 *
 * @author ataylor
 */
public class FourOfAKind extends ComplexHand {
    private Rank rank;
    
    public FourOfAKind(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        Map<Rank, Integer> freqs = hand.getRankFrequency();
        
        for (Rank r : freqs.keySet()) {
            if (freqs.get(r) == 4) {
                rank = r;
                return true;
            }
        }
        
        return false;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int getHandStrength() {
        return Hands.FOUR_OF_A_KIND.value;
    }
    
    @Override
    public String toString() {
        return "Four of a kind. " + super.toString();
    }
}
