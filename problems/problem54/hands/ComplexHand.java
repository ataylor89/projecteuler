package problems.problem54.hands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import problems.problem54.Card;
import problems.problem54.SimpleHand;

/**
 *
 * @author ataylor
 */
public abstract class ComplexHand implements Comparable<ComplexHand> {
    
    protected SimpleHand hand;
    protected List<Card> highCards;
    
    public ComplexHand(SimpleHand hand) {
        this.hand = hand;
        hand.sort();
    }
    
    public abstract boolean matches();

    public abstract int getHandStrength();

    public List<Card> getHighCards() {
        if (highCards == null) {
            highCards = new ArrayList<>(hand.getCards());
            Collections.reverse(highCards);
        }
        
        return highCards;
    }
    
    @Override
    public int compareTo(ComplexHand hand) {
        Integer strength1 = getHandStrength();
        Integer strength2 = hand.getHandStrength();
 
        int result;
        if ((result = strength1.compareTo(strength2)) != 0)
            return result;
        
        List<Card> hc1 = getHighCards();
        List<Card> hc2 = hand.getHighCards();
        
        for (int i = 0; i < hc1.size() && i < hc2.size(); i++) 
            if ((result = hc1.get(i).compareTo(hc2.get(i))) != 0)
                return result;
        
        return 0;
    }
    
    @Override
    public String toString() {
        return hand.toString();
    }
}
