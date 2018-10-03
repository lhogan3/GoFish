import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {

    // computer player's memory of your cards you ask
    ArrayList<String> memory = new ArrayList<String>();

    // does the computer remember your cars or not
    boolean isSmart;


    public String determineAsk(){

        // If computer is smart, we visit each card in memory and see if we hold that card - ask when we find the first match
        if (this.isSmart) {

            for (int i = 0; i < memory.size(); i++) {

                for (int j = 0; j < hand.size(); j++) {

                    if (memory.get(i).equals(hand.get(j).rank)) {

                        System.out.println("Player 2 asks for " + memory.get(i));
                        return memory.get(i);
                    }
                }

            }
        }

        // If computer is dumb OR we did not find any cards in memory that were also in hand...we ask for a random card from hand

        Random r = new Random();
        int index = r.nextInt((hand.size()-1) + 1);

        System.out.println("Player 2 asks for " + hand.get(index).rank);
        return hand.get(index).rank;

    }

}
