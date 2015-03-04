package problems.problem54.hands;

import java.util.Iterator;
import java.util.List;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;

/**
 *
 * @author ataylor
 */
public class Straight extends ComplexHand {

    private Rank rank;
    
    public Straight(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        List<Rank> ranks = hand.getRanks();
        
        // special case, ace-low straight
        if (ranks.get(0).equals(Rank.TWO)
                && ranks.get(1).equals(Rank.THREE) 
                && ranks.get(2).equals(Rank.FOUR)
                && ranks.get(3).equals(Rank.FIVE)
                && ranks.get(4).equals(Rank.ACE)) {
            
            this.rank = Rank.FIVE;
            return true;
        }
        
        // general case
        Iterator<Rank> it = ranks.iterator();
        
        Rank prev = it.next();
        
        while (it.hasNext()) {
            Rank cursor = it.next();
            
            if (prev.value != cursor.value - 1)
                return false;
            
            prev = cursor;
        }
        
        this.rank = ranks.get(4);
        return true;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public int getHandStrength() {
        return Hands.STRAIGHT.value + getRank().value;
    }
    
    @Override
    public String toString() {
        return "Straight. " + super.toString();
    }
}
