/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package war;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private final ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void generateStandardDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                cards.add(new Card(suit, rank));
            }
        }
        // Adding jokers (optional)
        cards.add(new Card("Joker", 0));
        cards.add(new Card("Joker", 0));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> deal(int numCards) {
        ArrayList<Card> hand = new ArrayList<>(cards.subList(0, numCards));
        cards.subList(0, numCards).clear();
        return hand;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}

