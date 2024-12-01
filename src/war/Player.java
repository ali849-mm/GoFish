/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package war;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void receiveCards(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard() {
        return hand.isEmpty() ? null : hand.remove(0);
    }

    public void addToHand(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public int getHandSize() {
        return hand.size();
    }
}

