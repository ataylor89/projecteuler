package problems.problem54.hands;

/**
 *
 * @author ataylor
 */
public enum Hands {
    HIGH_CARD(0),
    ONE_PAIR(1000),
    TWO_PAIR(2000),
    THREE_OF_A_KIND(3000),
    STRAIGHT(4000),
    FLUSH(5000),
    FULL_HOUSE(6000),
    FOUR_OF_A_KIND(7000),
    STRAIGHT_FLUSH(8000),
    ROYAL_FLUSH(9000);
    
    public int value;
    
    Hands(int value) {
        this.value = value;
    }
}