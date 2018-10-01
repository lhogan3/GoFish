import java.util.Comparator;

public class Card{

    // ace,2,3,etc.
    String rank;

    // heart,diamond,spade,club
    String suit;


    Card(String rank, String suit){

        this.rank = rank;
        this.suit = suit;


    }


//    public int compare(Card one, Card two){
//
//        int oneRank = Integer.parseInt(one.rank);
//        int twoRank = Integer.parseInt(two.rank);
//        int returnVal = 0;
//
//        if(oneRank < twoRank){
//            returnVal =  -1;
//        }else if(oneRank > twoRank){
//            returnVal =  1;
//        }else if(oneRank == twoRank){
//            returnVal =  0;
//        }
//        return returnVal;
//    }


    public int compareTo(Card card)
    {

        int oneRank = Integer.parseInt(this.rank);
        int twoRank = Integer.parseInt(card.rank);


        return(oneRank - twoRank);
    }
}