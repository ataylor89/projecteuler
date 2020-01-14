package problems.problem54.hands;

import problems.problem54.SimpleHand;

/**
 *
 * @author ataylor
 */
public class FullHouse extends ComplexHand {
    private ThreeOfAKind threeOfAKind;
    private OnePair onePair;
    
    public FullHouse(SimpleHand hand) {
        super(hand);
        
        threeOfAKind = new ThreeOfAKind(hand);
        onePair = new OnePair(hand);
    }

    @Override
    public boolean matches() {
        if (threeOfAKind.matches() && onePair.matches()) {
            if (threeOfAKind.getRank() != onePair.getRank()) 
                return true;
        }
        return false;
    }

    @Override
    public int getHandStrength() {
        return Hands.FULL_HOUSE.value + threeOfAKind.getRank().value;
    }
    
    @Override
    public String toString() {
        return "Full house. " + super.toString();
    }
}
