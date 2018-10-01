import java.util.ArrayList;

public class Deck {

    ArrayList<Card> cards;


    String[] SUITS = {"c", "d", "h", "s"};

    String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "1"};

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