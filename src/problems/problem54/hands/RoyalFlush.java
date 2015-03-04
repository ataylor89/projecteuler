package problems.problem54.hands;

import java.util.List;
import problems.problem54.Card;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;
import problems.problem54.Suit;

/**
 *
 * @author ataylor
 */
public class RoyalFlush extends ComplexHand {

    private StraightFlush straightFlush;
    
    public RoyalFlush(SimpleHand hand) {
        super(hand);
        
        straightFlush = new StraightFlush(hand);
    }
    
    @Override
    public boolean matches() {
        if (straightFlush.matches()) {
            if (getHighCards().get(0).rank == Rank.ACE)
                return true;
        }
        return false;
    }

    public Rank getRank() {
        return straightFlush.getRank();
    }

    public Suit getSuit() {
        return straightFlush.getSuit();
    }

    @Override
    public int getHandStrength() {
        return Hands.ROYAL_FLUSH.value;
    }
    
    public String toString() {
        return "Royal flush. " + super.toString();
    }
}
