package problems.problem54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ataylor
 */
public class SimpleHand {
    
    protected List<Card> cards;

    public SimpleHand() {
        cards = new ArrayList<>();
    }
    
    public void addCard(Card c) {
        if (cards.size() < 5) 
            cards.add(c);
        
        else
            throw new IllegalArgumentException("Too many cards in one hand: " + toString());
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    @Override
    public String toString() {
        return cards.toString();
    }
    
    public List<Card> getCards() {
        return cards;
    }
    
    public Card get(int i) {
        return cards.get(i);
    }
    
    public List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        
        for (int i = 0; i < cards.size(); i++) 
            ranks.add(cards.get(i).rank);
        
        return ranks;
    }
    
    public Map<Rank, Integer> getRankFrequency() {
        Map<Rank, Integer> m = new HashMap<>();
        
        for (Card c : cards) {
            int freq = m.containsKey(c.rank) ? m.get(c.rank) + 1 : 1;
            m.put(c.rank, freq);
        }
        
        return m;
    }
    
    public Map<Suit, Integer> getSuitFrequency() {
        Map<Suit, Integer> m = new HashMap<>();
        
        for (Card c : cards) {
            int freq = m.containsKey(c.suit) ? m.get(c.suit) + 1 : 1;
            m.put(c.suit, freq);
        }
        
        return m;
    }
}
