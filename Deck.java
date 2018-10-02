import java.util.ArrayList;

// Defining the Deck class.
public class Deck {

    //Deck is defined as an ArrayList of card objects.
    ArrayList<Card> cards;

    // Create array of suits.
    String[] SUITS = {"\u001B[31m"+ "\u2665" + "\u001B[0m","\u001B[31m" + "\u2666" + "\u001B[0m","\u2660","\u2663"};

    // Create array of ranks.
    String[] RANKS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    // Create deck of cards by looping through the suits and ranks and adding them to cards.
    Deck(){

        cards = new ArrayList<Card>();

        for (int i = 0; i < RANKS.length; i++) {

            for (int j = 0; j < SUITS.length; j++) {

                Card card = new Card(RANKS[i], SUITS[j]);

                cards.add(card);
            }
        }
    }
}