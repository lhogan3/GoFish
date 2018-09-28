
import java.util.ArrayList;
import java.util.Arrays;
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


    // cant use lamba expression in a for loop....so this is the best i got
    public void checkBooks(){

        if (hasFour(1)){

            hand.removeIf(card -> card.rank.equals(1));
            hand.trimToSize();
            books = books + 1;
        }

        if (hasFour(2)){

            hand.removeIf(card -> card.rank.equals(2));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(3)){

            hand.removeIf(card -> card.rank.equals(3));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(4)){

            hand.removeIf(card -> card.rank.equals(4));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(5)){

            hand.removeIf(card -> card.rank.equals(5));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(6)){

            hand.removeIf(card -> card.rank.equals(6));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(7)){

            hand.removeIf(card -> card.rank.equals(7));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(8)){

            hand.removeIf(card -> card.rank.equals(8));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(9)){

            hand.removeIf(card -> card.rank.equals(9));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(10)){

            hand.removeIf(card -> card.rank.equals(10));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(11)){

            hand.removeIf(card -> card.rank.equals(11));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(12)){

            hand.removeIf(card -> card.rank.equals(12));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour(13)){

            hand.removeIf(card -> card.rank.equals(13));
            hand.trimToSize();
            books = books + 1;

        }

    }

    public boolean hasFour(int rankSeek) {

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



