
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

        // TEST MODE ON / OFF
        boolean test = false;

        // Ask to Start Game
        Scanner scanner = new Scanner(System.in);

        System.out.println("Start New Game? (y)");
        System.out.println("Quit? (n)\n");

        String start = scanner.nextLine();

        while (!start.toLowerCase().equals("y") && !start.toLowerCase().equals("n")){

            System.out.println("Invalid Response...");
            System.out.println("Start New Game? (y)");
            System.out.println("Quit? (n)\n");

            start = scanner.nextLine();

        }

        // Start Game!
        if (start.toLowerCase().equals("y")) {

            // Initialize new deck of cards

            Deck deck = new Deck();

            // Note: in IntelliJ, to hide the blocks of code for testing (which we can get rid of soon), click the if statement and
            // do ctrl-shift-period / command-shift-period

            // FOR TESTING
            if (test) {

                System.out.println("\n");

                System.out.println("---------------FULL DECK CARDS------------------------\n");

                for (int p = 0; p < deck.cards.size(); p++) {

                    System.out.println(deck.cards.get(p).rank + " of " + deck.cards.get(p).suit);

                }

            }

            // Shuffle the deck

            System.out.println("shuffling...");
            Collections.shuffle(deck.cards);


            // FOR TESTING
            if (test) {

                System.out.println("\n");

                System.out.println("---------------SHUFFLED FULL DECK------------------------\n");

                for (int p = 0; p < deck.cards.size(); p++) {

                    System.out.println(deck.cards.get(p).rank + " of " + deck.cards.get(p).suit);

                }

            }

            // Initialize Player 1 and Player 2
            Player P1 = new Player();
            Player P2 = new ComputerPlayer();


            System.out.println("dealing...\n");
            // Deal 7 cards to P1's hand, remove cards from deck, update deck size
            for (int i = 0; i < 7; i++) {
                P1.hand.add(deck.cards.get(i));
                deck.cards.remove(i);
            }

            // Deal 7 cards to P2's hand, remove cards from deck, update deck size
            for (int i = 0; i < 7; i++) {
                P2.hand.add(deck.cards.get(i));
                deck.cards.remove(i);
            }

            // Adjust deck size after dealing
            deck.cards.trimToSize();

            // FOR TESTING
            if (test) {

                System.out.println("\n");

                System.out.println("---------------P1 HAND------------------------\n");

                for (int p = 0; p < P1.hand.size(); p++) {

                    System.out.println(P1.hand.get(p).rank + " of " + P1.hand.get(p).suit);

                }

                System.out.println("---------------P2 HAND------------------------\n");

                for (int p = 0; p < P2.hand.size(); p++) {

                    System.out.println(P2.hand.get(p).rank + " of " + P2.hand.get(p).suit);

                }
            }

            // Rank Selection Menu
            System.out.println("\n");
            System.out.println("Rank selection menu:");
            System.out.println("2   3   4   5   6");
            System.out.println("7     8    9    10");
            System.out.println("Jack - 11    Queen - 12");
            System.out.println("King - 13   Ace - 1\n");


            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // GAME LOOP //

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            while (true) {  // there are no cards in deck and no cards in hands ends game TEST COMMIT

                // Start P1 turn (keep asking until go fish and go fish is not card requested)
                boolean P1Turn = true;
                while (P1Turn) {

                    // Ask Player 1 which rank they would like to ask for
                    String rankAsk = P1.ask();

                    boolean goFish = true;
                    // TODO: Decide if P2 lying or not
                    // Loop through P2 hands looking for cards of requested rank
                    for (int i = 0; i < P2.hand.size(); i++) {

                        // If we find a card with the requested rank...
                        if (P2.hand.get(i).rank.equals(rankAsk)) { //TODO: and not lying
                            // we're not going fishing
                            goFish = false;

                            // Add the card to P1's hand
                            Card cardtoAdd = P2.hand.get(i);
                            System.out.println("You got " + P2.hand.get(i).rank + " of " + P2.hand.get(i).suit + " from P2!");
                            P1.hand.add(cardtoAdd);
                        }
                    }

                    // TODO: If not lying...
                    // Remove all (if any) cards of the requested rank from P2's hand // TODO: Need to make it so we can combine this with above for lie percentage
                    P2.hand.removeIf(card -> card.rank.equals(rankAsk));
                    P2.hand.trimToSize();


                    // if we found no cards (or P2 is lying), we FISH!
                    if (goFish) { //TODO: && deck.cards.size != 0

                        System.out.println("Player 2 says, GO FISH!");

                        // Grab card off top of deck/pool
                        Card draw = deck.cards.get(0);

                        // Add to P1 hand
                        P1.hand.add(draw);

                        // Remove from deck and resize
                        deck.cards.remove(0);
                        deck.cards.trimToSize();

                        // Check to see if card was what P1 asked for...continue game if yes
                        if (draw.rank.equals(rankAsk)) {

                            P1Turn = true;

                        }

                        // Else, end P1's turn
                        else{

                            P1Turn = false;
                        }
                    }

                    // Check for new books!
                    P1.checkBooks();


                    // TESTING
                    System.out.println("Books: " + P1.books);

                }




                // TODO: Check to make sure game is not over (check P1 books + P2 books = ?)


                System.out.println("P2 turn begins...");



                //TODO - P2.turn()

                // TODO: Computer Player (smart and dumb modes)
                // TODO: Check if game is not over
                // TODO: Make it loop
                // TODO: Add lie percentage - (directions say on responses so that's just changing one spot highlighted above)


                if (test) {
                    System.out.println("---------------P2 HAND------------------------\n");

                    for (int p = 0; p < P2.hand.size(); p++) {

                        System.out.println(P2.hand.get(p).rank + " of " + P2.hand.get(p).suit);

                    }
                }
                
            }
        }

        // Quit game
        else{

            System.out.println("Bye now");
            System.exit(0);
        }

    }
}