package problems.problem54.hands;

import problems.problem54.SimpleHand;

/**
 *
 * @author ataylor
 */
public class HighCard extends ComplexHand {

    public HighCard(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        return true;
    }

    @Override
    public int getHandStrength() {
        return Hands.HIGH_CARD.value;
    }
    
    @Override
    public String toString() {
        return "High card. " + super.toString();
    }
    
}
