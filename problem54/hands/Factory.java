package problems.problem54.hands;

import problems.problem54.SimpleHand;

/**
 *
 * @author ataylor
 */
public class Factory {
    public static ComplexHand getTypeOfHand(SimpleHand hand) {
        ComplexHand h;
        hand.sort();
        
        if ((h = new RoyalFlush(hand)).matches()) 
            return h;
        else if ((h = new StraightFlush(hand)).matches())
            return h;
        else if ((h = new FourOfAKind(hand)).matches())
            return h;
        else if ((h = new FullHouse(hand)).matches())
            return h;
        else if ((h = new Flush(hand)).matches())
            return h;
        else if ((h = new Straight(hand)).matches())
            return h;
        else if ((h = new ThreeOfAKind(hand)).matches())
            return h;
        else if ((h = new TwoPair(hand)).matches())
            return h;
        else if ((h = new OnePair(hand)).matches())
            return h;
        else 
            return new HighCard(hand);
    }
}
