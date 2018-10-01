import java.util.ArrayList;
import java.util.Scanner;

//Defining the Player class.
public class Player {

    // A player has a hand, and it is defined as an ArrayList
    // of Card objects.
    ArrayList<Card> hand;

    // Options of things the human player can ask for.
    // Don't want them asking for cards they don't have
    // in their hand.
    ArrayList<String> options = new ArrayList<String>();

    // Number of books the Player has.
    int books;

    // Player constructor giving the Player a hand.
    Player(){

        hand = new ArrayList<Card>();

    }


    // Method for when the Player asks the Computer for a card.
    public String ask() {

        // Displays the Player's hand.
        System.out.println("---------------YOUR HAND------------------------");

        for (int p = 0; p < hand.size(); p++) {

            System.out.println(hand.get(p).rank + " of " + hand.get(p).suit);

        }

        for (int p = 0; p < hand.size(); p++) {

            options.add(hand.get(p).rank);

        }

        // Have the Player enter the card they want to ask.
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("Ask P2 if they have any ... ?   (q to quit)");

        String rank = scanner.nextLine();

        // Quit the game if the Player enters q or Q at any time during the game.
        if (rank.equals("q") || rank.equals("Q")){

            System.out.println("Bye now");
            System.exit(0);
        }

        // If the rank asked for is in the player's hand then proceed.
        if (options.contains(rank)) {

            return rank;

        }

        // If the card asked for is not in the Player's hand, then don't let them ask for this card.
        else {

            while (!options.contains(rank)) {

                if (rank.equals("q") || rank.equals("Q")){

                    System.out.println("Bye now");
                    System.exit(0);
                }
                System.out.println("Invalid Rank Entered / You do not have that rank...\n");

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

            P2.hand.removeIf(card -> card.rank.equals(rankOfInterest));

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
