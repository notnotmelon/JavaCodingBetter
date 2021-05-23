package AP_Abstract_Golf;

import java.util.ArrayList;
import java.util.List;

/*
cannot find symbol error?
Build -> Rebuild
 */

public class AbstractPlayer implements Playerable{
    private String name;
    private ArrayList<Card> hand;
    private int wins;

    public AbstractPlayer(String n){
        name = n;
        hand = new ArrayList<>();
        wins = 0;
    }

    public AbstractPlayer(){
        this("Bob");
    }

    public void addCardToHand(Card c){
        hand.add(c);
    }

    public void resetHand(){
        hand = new ArrayList<>();
    }

    public void setWinCount(int w){
        wins = w;
    }

    public int getWinCount(){
        return wins;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public int swapCards(int i, Card c){
        if(i < 0 || i >= getHandSize() ){
            return -1;
        }

        hand.set(i, c);

        return 1;
    }

    public int getHandSize(){
        return hand.size();
    }

    public int getHandValue(){
        int cnt = 0;
        for(Card j : hand){
            cnt += j.getValue();
        }
        return cnt;
    }

    public List<Card> getHand(){
        return hand;
    }

    public String toString(){
        return name+"'s hand = " + getHand() + " - " + getHandValue();
    }
}
