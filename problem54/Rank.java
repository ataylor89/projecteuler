package problems.problem54;

/**
 *
 * @author ataylor
 */
public enum Rank {
    
    TWO (0, "2"),
    THREE (1, "3"),
    FOUR (2, "4"),
    FIVE (3, "5"),
    SIX (4,  "6"),
    SEVEN (5, "7"),
    EIGHT (6, "8"),
    NINE (7, "9"),
    TEN (8, "T"),
    JACK (9, "J"),
    QUEEN (10, "Q"),
    KING (11, "K"),
    ACE (12, "A");
    
    public Integer value;
    public String shorthand;
    
    Rank(Integer value, String shorthand) {
        this.value = value;
        this.shorthand = shorthand;
    }
    
    @Override
    public String toString() {
        return shorthand;
    }
    
    public static Rank fromShorthand(String s) {
        for (Rank r : values()) 
            if (r.shorthand.equals(s))
                    return r;
        
        throw new IllegalArgumentException("Rank does not exist for shorthand: " + s);
    }
    
    public static Rank fromIntegerValue(Integer v) {
        for (Rank r : values()) 
           if (r.value == v)
               return r;
        
        throw new IllegalArgumentException("Rank does not exist for value: " + v);
    }
}
