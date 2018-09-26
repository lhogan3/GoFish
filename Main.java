package com.company;
import java.util.Collections;
import java.util.Scanner;

// test 2 comment

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

                for (int p = 0; p < deck.size; p++) {

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

                for (int p = 0; p < deck.size; p++) {

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
                deck.size = deck.cards.size(); // dont really need this, just use deck.cards.size?
            }

            // Deal 7 cards to P2's hand, remove cards from deck, update deck size
            for (int i = 0; i < 7; i++) {
                P2.hand.add(deck.cards.get(i));
                deck.cards.remove(i);
                deck.size = deck.cards.size(); // dont really need this, just use deck.cards.size?
            }

            // FOR TESTING
            if (test) {

                System.out.println("\n");

                System.out.println("---------------P1 HAND------------------------\n");

                for (int p = 0; p < P1.hand.size(); p++) {

                    System.out.println(P1.hand.get(p).rank + " of " + P1.hand.get(p).suit);

                }

                System.out.println("---------------P2 HAND------------------------\n");

                for (int p = 0; p < P1.hand.size(); p++) {

                    System.out.println(P2.hand.get(p).rank + " of " + P2.hand.get(p).suit);

                }
            }


            // TODO: START GAME LOOP ...........................................................................

            System.out.println("Rank selection menu:");
            System.out.println("2   3   4   5   6");
            System.out.println("7     8    9    10");
            System.out.println("Jack - 11    Queen - 12");
            System.out.println("King - 13   Ace - 1\n");

            while (true){  // there are no cards in deck and no cards in hands


                String rankAsk = P1.ask();

                boolean goFish = true;
                for (int i = 0; i < P2.hand.size(); i++){


                    if (P2.hand.get(i).rank.equals(rankAsk)){

                        System.out.println(P2.hand.get(i).rank + " of " + P2.hand.get(i).suit);
                        goFish = false;

                    }

                }

                if (goFish){

                    System.out.println("GO FISH");                }

            }
        }

        // Quit game
        else{

            System.out.println("Bye now");
            System.exit(0);
        }

    }
}