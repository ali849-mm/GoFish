/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package war;

import java.util.ArrayList;

public class War {
    private final ArrayList<Player> players;
    private final GroupOfCards deck;

    public War() {
        players = new ArrayList<>();
        deck = new GroupOfCards();
    }

    public void setupGame(int numPlayers) {
        deck.generateStandardDeck();
        deck.shuffle();
        int cardsPerPlayer = deck.getCards().size() / numPlayers;
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player("Player " + (i + 1));
            player.receiveCards(deck.deal(cardsPerPlayer));
            players.add(player);
        }
    }

    public void play() {
        System.out.println("Starting a game of War!");

        while (players.stream().allMatch(Player::hasCards)) {
            ArrayList<Card> roundCards = new ArrayList<>();
            for (Player player : players) {
                Card card = player.playCard();
                System.out.println(player.getName() + " plays " + card);
                roundCards.add(card);
            }

            handleRound(roundCards);

            // End game if one player has no cards
            if (players.stream().anyMatch(player -> !player.hasCards())) {
                break;
            }
        }

        declareWinner();
    }

    private void handleRound(ArrayList<Card> roundCards) {
        Card highestCard = null;
        Player roundWinner = null;

        // Determine the winner of the current round
        for (int i = 0; i < roundCards.size(); i++) {
            Card currentCard = roundCards.get(i);
            Player currentPlayer = players.get(i);

            if (currentCard.getRank() > (highestCard != null ? highestCard.getRank() : -1)) {
                highestCard = currentCard;
                roundWinner = currentPlayer;
            } else if (currentCard.getRank() == (highestCard != null ? highestCard.getRank() : -1)) {
                // Handle tie (trigger War)
                System.out.println("It's a tie! Time for WAR!");
                handleWar(roundCards);
                return; // Exit the method after handling the tie
            }
        }

        // If we have a round winner, award the cards
        if (roundWinner != null) {
            System.out.println(roundWinner.getName() + " wins the round!");
            roundWinner.addToHand(roundCards);
        }
    }

    private void handleWar(ArrayList<Card> roundCards) {
        ArrayList<Card> warPile = new ArrayList<>(roundCards);

        // Each player places three cards face-down and one card face-up
        for (Player player : players) {
            if (player.getHandSize() < 4) {
                // Player can't participate in War due to insufficient cards
                System.out.println(player.getName() + " does not have enough cards for War!");
                declareWinner();
                System.exit(0);
            }

            // Add three face-down cards to the war pile
            for (int i = 0; i < 3; i++) {
                warPile.add(player.playCard());
            }

            // Add one face-up card to the war pile
            Card warCard = player.playCard();
            System.out.println(player.getName() + " plays " + warCard + " as the War card!");
            warPile.add(warCard);
        }

        // Determine the winner of the War round
        handleRound(warPile);
    }

    private void declareWinner() {
        Player winner = players.stream()
                .filter(Player::hasCards)
                .findFirst()
                .orElse(null);

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + "!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        War game = new War();
        game.setupGame(2); // Set up for 2 players
        game.play();
    }
}