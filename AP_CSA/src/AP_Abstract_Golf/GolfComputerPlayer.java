package AP_Abstract_Golf;

import java.util.List;

public class GolfComputerPlayer extends Player{

    //if a card's value is greater than this
    private static int hiV = 6;

    public GolfComputerPlayer(String name){
        super(name);
    }

    public GolfComputerPlayer(){
        super();
    }

//    public int getIndex(AP_Abstract_Golf.Card c){
//        return getHand().indexOf(c);
//    }

    public static void setLowValue(int n){
        hiV = n;
    }

    public boolean shouldSwap(){
        return getHand().get(indexOfHigh()).getValue() > hiV;
    }

    public int indexOfHigh(){
        int b = 0;
        List<Card> h = getHand();

        for(int i = 1; i<getHandSize(); i++){
            if(h.get(i).getValue() > h.get(b).getValue()){
                b = i;
            }
        }

        return b;
    }
}
