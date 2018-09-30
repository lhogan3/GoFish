
import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {
    // computer player's memory of your cards you ask
    ArrayList<Card> memory;
    // probability the computer lies to you when you ask for a card
    int lyingChance;
    // does the computer remember your cards or not
    boolean isSmart;

    public String ask(){
        if(isSmart){

        }
        else{
            Random generator = new Random();
            int askInt = (generator.nextInt(13) + 1);
            String ask = Integer.toString(askInt);
            return ask;
        }

    }
}
