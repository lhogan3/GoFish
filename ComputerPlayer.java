
import java.util.ArrayList;

public class ComputerPlayer extends Player {

    // computer player's memory of your cards you ask
    ArrayList<String> memory = new ArrayList<String>();

    // probability the computer lies to you when you ask for a card
    int lyingChance;

    // does the computer remember your cars or not
    boolean isSmart;

}

