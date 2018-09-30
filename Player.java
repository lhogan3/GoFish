
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Player {

    // players hand
    ArrayList<Card> hand;

    //
    ArrayList<String> options = new ArrayList<String>();

    // amount of sets of 4 the player has
    int books;

    Player(){

        hand = new ArrayList<Card>();

    }


    // player asks computer for a card
    public String ask() {

        // display player's hand
        System.out.println("---------------YOUR HAND------------------------");

        for (int p = 0; p < hand.size(); p++) {

            System.out.println(hand.get(p).rank + " of " + hand.get(p).suit);

        }

        for (int p = 0; p < hand.size(); p++) {

            options.add(hand.get(p).rank);

        }


        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Ask P2 if they have any ... ?   (q to quit)");

        String rank = scanner.nextLine();

        if (rank.equals("q") || rank.equals("Q")){

            System.out.println("Bye now");
            System.exit(0);
        }

        if (options.contains(rank)) {

            return rank;

        } else {

            while (!options.contains(rank)) {

                if (rank.equals("q") || rank.equals("Q")){

                    System.out.println("Bye now");
                    System.exit(0);
                }
                System.out.println("Invalid Rank Entered...\n");

                System.out.println("Ask P2 if they have any ... ?   (q to quit)");

                rank = scanner.nextLine();
            }

            return rank;
        }
    }


        // check either requested rank (if P1 recieved cards) or the card that was draw from GO FISH.
        public void checkBooks(ComputerPlayer P2, String rankOfInterest){

        if (hasFour(rankOfInterest)) {

            hand.removeIf(card -> card.rank.equals(rankOfInterest));
            hand.trimToSize();
            books = books + 1;

            for (int item = 0; item < P2.memory.size(); item++) {

                if (P2.memory.get(item) == rankOfInterest) {

                    P2.memory.remove(item);
                    P2.memory.trimToSize();
                }

            }
        }
    }

    public boolean hasFour(String rankSeek) {

        int sum = 0;


        for (int card = 0; card < hand.size(); card++) {


            if (hand.get(card).rank.equals(rankSeek)) {

                sum = sum + 1;

            }
        }

        if (sum == 4) {

            return true;
        } else {

            return false;
        }

    }
}



