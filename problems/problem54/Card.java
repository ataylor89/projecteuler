package problems.problem54;

/**
 *
 * @author ataylor
 */
public class Card implements Comparable<Card> {

    public Suit suit;
    public Rank rank;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compareTo(Card c) {
        return rank.value.compareTo(c.rank.value);
    }
    
    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }
    
    public static Card fromShorthand(String shorthand) {
        assert shorthand.length() == 2;
        
        String r = shorthand.substring(0, 1);
        String s = shorthand.substring(1, 2);
        
        Rank rank = Rank.fromShorthand(r);
        Suit suit = Suit.fromShorthand(s);
        
        return new Card(suit, rank);
    }
}
