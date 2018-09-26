package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {


    ArrayList<Card> hand;

    ArrayList<String> guesses = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "1"));


    Player(){

        hand = new ArrayList<Card>();

    }



    public String ask() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ask P2 if they have any ... ?   (q to quit)");

        String rank = scanner.nextLine();

        if (rank.equals("q") || rank.equals("Q")){

            System.out.println("Bye now");
            System.exit(0);
        }

        if (guesses.contains(rank)) {

            return rank;

        } else {

            while (!guesses.contains(rank)) {

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



