/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package war;

/**
 * Represents a single playing card with a rank and suit.
 */
public class Card {
    private String suit;
    private int rank; // Numeric rank (2-14, where 11=Jack, 12=Queen, 13=King, 14=Ace)

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rankToString() + " of " + suit;
    }

    private String rankToString() {
        switch (rank) {
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            case 14: return "Ace";
            default: return String.valueOf(rank);
        }
    }
}
