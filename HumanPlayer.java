import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player{

    //the ranks of the cards in the players hand. (I think?)
    ArrayList<String> options = new ArrayList<String>();

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

}
