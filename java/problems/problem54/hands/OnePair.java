package problems.problem54.hands;

import java.util.Map;
import problems.problem54.SimpleHand;
import problems.problem54.Rank;

/**
 *
 * @author ataylor
 */
public class OnePair extends ComplexHand {
    private Rank rank;
    
    public OnePair(SimpleHand hand) {
        super(hand);
    }
    
    @Override
    public boolean matches() {
        Map<Rank, Integer> freqs = hand.getRankFrequency();

        for (Rank r : freqs.keySet()) {
            if (freqs.get(r) == 2) {
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
        return Hands.ONE_PAIR.value + rank.value;
    }
    
    @Override
    public String toString() {
        return "One pair. " + super.toString();
    }
}
