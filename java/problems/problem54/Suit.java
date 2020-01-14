package problems.problem54;

/**
 *
 * @author ataylor
 */
public enum Suit {
    
    HEART ("H"), DIAMOND ("D"), SPADE ("S"), CLUB ("C");
    
    String shorthand;
    
    Suit(String shorthand) {
        this.shorthand = shorthand;
    }
    
    @Override
    public String toString() {
        return shorthand;
    }
    
    public static Suit fromShorthand(String str) {
        for (Suit suit : values()) 
            if (suit.shorthand.equals(str))
                    return suit;
        
        throw new IllegalArgumentException("Suit does not exist for shorthand: " + str);
    }
}
