package AP_Abstract_Golf;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	//top card index
	private int tI;
	//stack of cards
	private ArrayList<Card> sC;

	public Deck ()
	{
		tI = NUMCARDS - 1;
		sC = new ArrayList<>();

		for(String j : SUITS){
			for(int i = 0; i<NUMFACES; i++){
				sC.add(new GolfCard(i+1, j));
			}
		}
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		Collections.shuffle(sC);
		//reset variables as needed
		tI = NUMCARDS - 1;
	}

	public void setTopCard(int i){
		tI = i;
	}

   //accessors
	public int  size ()
	{
		return NUMCARDS;
	}

	public int numCardsLeft()
	{
		return tI + 1;
	}

	public Card nextCard()
	{
		try{
			return sC.get(tI--);
		}catch(ArrayIndexOutOfBoundsException e){
			tI = NUMCARDS - 1;
			return nextCard();
		}
	}

	public String toString()
	{
		return sC+ "   topCardIndex = " + tI;
	} 
}