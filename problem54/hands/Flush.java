package problems.problem54.hands;

import java.util.List;
import java.util.Map;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;
import problems.problem54.Suit;

/**
 *
 * @author ataylor
 */
public class Flush extends ComplexHand {
    private Suit suit;
    private Rank rank;
    
    public Flush(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        Map<Suit, Integer> m = hand.getSuitFrequency();
        
        for (Suit s : m.keySet()) {
            if (m.get(s) == 5) {
                suit = s;
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "Flush of " + suit.toString() + ". " + super.toString();
    }

    public Rank getRank() {
        if (rank == null)
            rank = getHighCards().get(0).rank;
        
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int getHandStrength() {
        return Hands.FLUSH.value + getRank().value;
    }
}
