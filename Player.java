
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public abstract class Player {

    String type;

    public abstract String getType();

    // players hand
    ArrayList<Card> hand;

    ArrayList<Card> memory;

    // amount of sets of 4 the player has
    int books;

    Player(){

        hand = new ArrayList<Card>();

    }

    public abstract String ask();

    // cant use lamba expression in a for loop....so this is the best i got
    public void checkBooks(){

        if (hasFour("1")){

            hand.removeIf(card -> card.rank.equals("1"));
            hand.trimToSize();
            books = books + 1;
        }

        if (hasFour("2")){

            hand.removeIf(card -> card.rank.equals("2"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("3")){

            hand.removeIf(card -> card.rank.equals("3"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("4")){

            hand.removeIf(card -> card.rank.equals("4"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("5")){

            hand.removeIf(card -> card.rank.equals("5"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("6")){

            hand.removeIf(card -> card.rank.equals("6"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("7")){

            hand.removeIf(card -> card.rank.equals("7"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("8")){

            hand.removeIf(card -> card.rank.equals("8"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("9")){

            hand.removeIf(card -> card.rank.equals("9"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("10")){

            hand.removeIf(card -> card.rank.equals("10"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("11")){

            hand.removeIf(card -> card.rank.equals("11"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("12")){

            hand.removeIf(card -> card.rank.equals("12"));
            hand.trimToSize();
            books = books + 1;

        }

        if (hasFour("13")){

            hand.removeIf(card -> card.rank.equals("13"));
            hand.trimToSize();
            books = books + 1;

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



