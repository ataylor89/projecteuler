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
public class StraightFlush extends ComplexHand {
    
    private Straight straight;
    private Flush flush;
    
    public StraightFlush(SimpleHand hand) {
        super(hand);
        
        straight = new Straight(hand);
        flush = new Flush(hand);
    }

    @Override
    public boolean matches() {
        return straight.matches() && flush.matches();
    }

    @Override
    public List<Card> getHighCards() {
        return straight.getHighCards();
    }

    public Rank getRank() {
        return straight.getRank();
    }

    public Suit getSuit() {
        return flush.getSuit();
    }

    @Override
    public int getHandStrength() {
        return Hands.STRAIGHT_FLUSH.value;
    }
    
    @Override
    public String toString() {
        return "Straight flush. " + super.toString();
    }
}
