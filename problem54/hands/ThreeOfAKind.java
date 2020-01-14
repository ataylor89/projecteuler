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
public class ThreeOfAKind extends ComplexHand {

    private Rank rank;
    
    public ThreeOfAKind(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        Map<Rank, Integer> freqs = hand.getRankFrequency();
        
        for (Rank r : freqs.keySet()) {
            if (freqs.get(r) == 3) {
                rank = r;
                return true;
            }
        }
        
        return false;
    }

    @Override
    public List<Card> getHighCards() {
        if (highCards == null) {
            highCards = new ArrayList<>();
            
            Map<Rank, Integer> freqs = hand.getRankFrequency();

            for (Card c : hand.getCards()) 
                if (freqs.get(c.rank) != 3)
                    highCards.add(c);
        }
        return highCards;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int getHandStrength() {
        return Hands.THREE_OF_A_KIND.value;
    }
    
    @Override
    public String toString() {
        return "Three of a kind. " + super.toString();
    }
}
