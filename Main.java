import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
            System.out.println("\n");
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
            ComputerPlayer P2 = new ComputerPlayer();


            // Get game mode (smart / dumb)
            System.out.println("Smart (s) or Dumb (d) Computer Mode?");
            String mode = scanner.nextLine();

            while (!mode.toLowerCase().equals("s") && !mode.toLowerCase().equals("d")){

                System.out.println("Invalid Response...");
                System.out.println("Smart (s) or Dumb (d) Computer Mode?");

                mode = scanner.nextLine();

            }

            // Set Computer Mode
            if (mode.toLowerCase().equals("s")){
                P2.isSmart = true;
            }
            else{
                P2.isSmart = false;
            }

            // Get Computer Lie Percentage
            System.out.println("Computer Lie Percentage? (0-100)");

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }

            Integer lie = scanner.nextInt();

            while (lie < 0 || lie > 100) {

                while (!scanner.hasNextInt()) {
                    String input = scanner.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);

                    System.out.println("Invalid Response...");
                    System.out.println("Computer Lie Percentage? (0-100)");

                    lie = scanner.nextInt();

                }
            }

            // Print settings
            System.out.println("\n");
            System.out.println("Mode set to: " + mode);
            System.out.println("Computer Lie Percentage set to: " + lie);



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

            // new game to start file over
            PrintWriter newGame = null;

            // create new game printer
            try {
                newGame =  new PrintWriter(new BufferedWriter(new FileWriter("goFishRecord.txt",false)));
            } catch (IOException ex) {
                System.out.println("File does not exist could not clear");
            }

            // clears file prints new game
            newGame.append("New Game:\n");
            // close file
            newGame.close();

            int turnCounter = 0;

            while (true) {  // there are no cards in deck and no cards in hands ends game TEST COMMIT
                turnCounter++;
                // create writer to write to file
                PrintWriter fileRecord = null;
                // create game recorder
                try {
                    fileRecord = new PrintWriter(new BufferedWriter(new FileWriter("goFishRecord.txt",true)));
                } catch (IOException ex){
                    System.out.println("File does not exist game will not be recorded");
                }

                // turn number
                fileRecord.append("Turn number: " + turnCounter + "\n");
                // print hands to file
                fileRecord.append("---------------Player 1 HAND------------------------\n");

                for (int p = 0; p < P1.hand.size(); p++) {

                    fileRecord.append(P1.hand.get(p).rank + " of " + P1.hand.get(p).suit + "\n");

                }

                fileRecord.append("---------------Player 2 HAND------------------------\n");

                for (int p = 0; p < P2.hand.size(); p++) {

                    fileRecord.append(P2.hand.get(p).rank + " of " + P2.hand.get(p).suit + "\n");

                }

                fileRecord.close();

                // Start P1 turn (keep asking until go fish (and go fish is not card requested))
                boolean P1Turn = true;
                while (P1Turn) {

                    String rankAsk1;

                    if (P1.hand.size() == 0){

                        // Grab card off top of deck/pool
                        Card draw = deck.cards.get(0);

                        // Add to P1 hand
                        P1.hand.add(draw);

                        // Remove from deck and resize
                        deck.cards.remove(0);
                        deck.cards.trimToSize();

                        System.out.println("You ran out of cards, you went fishing...");
                        System.out.println("You drew a: " + draw.rank + " of " + draw.suit + " !");

                        rankAsk1 = draw.rank;

                    }


                    else {
                        // Ask Player 1 which rank they would like to ask P2 for
                        rankAsk1 = P1.ask();
                    }

                    // Add the requested rank to P2's "memory" if it is not already in it
                    // (P2 believes P1 has at least one of this rank (remove when P2 gets this card rank back or a book is laid down of that rank)
                    if (P2.isSmart && !P2.memory.contains(rankAsk1)) {
                        P2.memory.add(rankAsk1);
                    }

                    // Go Fish flag
                    boolean goFish = true;

                    // Set if P2 should be lying based on lie percentage
                    boolean compLie;

                    if(new java.util.Random().nextInt(100) <= lie){
                        compLie = true;
                    }
                    else{
                        compLie = false;
                    }


                    // Loop through P2 hands looking for cards of requested rank
                    for (int i = 0; i < P2.hand.size(); i++) {

                        // If we find a card with the requested rank and P2 is not lying...
                        if (P2.hand.get(i).rank.equals(rankAsk1) && !compLie) {

                            // we're not going fishing
                            goFish = false;

                            // Add the card to P1's hand
                            Card cardtoAdd = P2.hand.get(i);
                            System.out.println("You got " + P2.hand.get(i).rank + " of " + P2.hand.get(i).suit + " from P2!");
                            P1.hand.add(cardtoAdd);
                        }
                    }

                    // Also if P2 not lying, this removes cards from their hand
                    if (!compLie) {
                        // Remove all (if any) cards of the requested rank from P2's hand
                        P2.hand.removeIf(card -> card.rank.equals(rankAsk1));
                        P2.hand.trimToSize();
                    }


                    // if we found no cards (or P2 is lying), we FISH!
                    if (goFish && deck.cards.size() != 0) {

                        System.out.println("\n");
                        System.out.println("Player 2 says, GO FISH!");

                        // Grab card off top of deck/pool
                        Card draw = deck.cards.get(0);

                        // Add to P1 hand
                        P1.hand.add(draw);

                        System.out.println("You drew a: " + draw.rank + " of " + draw.suit + " !");


                        // Remove from deck and resize
                        deck.cards.remove(0);
                        deck.cards.trimToSize();

                        // Check to see if card was what P1 asked for...continue game if yes
                        if (draw.rank.equals(rankAsk1)) {

                            P1Turn = true;

                        }

                        // Else, end P1's turn
                        else{

                            P1Turn = false;
                        }
                    }

                    // Check for new books!

                    if (goFish) {

                        P1.checkBooks(P2, P1.hand.get(P1.hand.size()-1).rank);

                    }

                    else{

                        P1.checkBooks(P2, rankAsk1);

                    }

                    System.out.println("\n");
                    System.out.println("Your Books: " + P1.books);

                }




                // TODO: Check to make sure game is not over (check P1 books + P2 books = ?)
                // I think a break will work here (will break while true game loop

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                System.out.println("Memory : " + P2.memory);

                System.out.println("P2 turn begins...");

                boolean P2Turn = true;

                String rankAsk2Temp;


                while (P2Turn) {

                    if (P2.hand.size() == 0){

                        // Grab card off top of deck/pool
                        Card draw = deck.cards.get(0);

                        // Add to P1 hand
                        P2.hand.add(draw);

                        // Remove from deck and resize
                        deck.cards.remove(0);
                        deck.cards.trimToSize();

                        System.out.println("P2 ran out of cards and went fishing...");

                        rankAsk2Temp = draw.rank;

                    }

                    else {

                        rankAsk2Temp = P2.determineAsk();

                    }
                    String rankAsk2 = rankAsk2Temp;
                    // Go Fish flag
                    boolean goFish = true;


                    // Loop through P1 hands looking for cards of requested rank
                    for (int i = 0; i < P1.hand.size(); i++) {

                        // If we find a card with the requested rank and P2 is not lying...
                        if (P1.hand.get(i).rank.equals(rankAsk2)) {

                            P2.memory.removeIf(m -> m.equals(rankAsk2));
                            P2.memory.trimToSize();


                            // we're not going fishing
                            goFish = false;

                            // Add the card to P2's hand
                            Card cardtoAdd = P1.hand.get(i);
                            System.out.println("You gave " + P1.hand.get(i).rank + " of " + P1.hand.get(i).suit + " to P2!");
                            P2.hand.add(cardtoAdd);
                        }
                    }


                    P1.hand.removeIf(card -> card.rank.equals(rankAsk2));
                    P1.hand.trimToSize();

                    // if we found no cards, make them FISH!
                    if (goFish && deck.cards.size() != 0) {

                        System.out.println("\n");
                        System.out.println("You tell P2 to, GO FISH!");

                        // Grab card off top of deck/pool
                        Card draw = deck.cards.get(0);

                        // Add to P1 hand
                        P2.hand.add(draw);

                        // Remove from deck and resize
                        deck.cards.remove(0);
                        deck.cards.trimToSize();

                        // Check to see if card was what P2 asked for...continue game if yes
                        if (draw.rank.equals(rankAsk2)) {

                            P2Turn = true;

                        }

                        // Else, end P2's turn
                        else{

                            P2Turn = false;
                        }
                    }

                    // Check for new books!

                    if (goFish) {

                        P2.checkBooks(P2, P2.hand.get(P2.hand.size()-1).rank);

                    }

                    else{

                        P2.checkBooks(P2, rankAsk2);

                    }

                    System.out.println("\n");
                    System.out.println("Player 2 Books: " + P2.books);


                    // TODO: Check for end of game after P2's turn, end game - print scores
                    // TODO: Add in recording
                    // TODO: Clean up 'UI'
                    // TODO: Make presentation
                    // TODO: First section of paper


                }


                System.out.println("---------------P2 HAND------------------------\n");

                for (int p = 0; p < P2.hand.size(); p++) {

                    System.out.println(P2.hand.get(p).rank + " of " + P2.hand.get(p).suit);

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