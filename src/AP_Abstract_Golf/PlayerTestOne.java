package AP_Abstract_Golf;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class PlayerTestOne
{
	public static void main( String[] args )
	{
		Player player = new Player();	
		
		Deck deck = new Deck();
		deck.shuffle();
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("\n\ntoString");
		out.println(player);	
		
		out.println("\n\nhandValue");
		out.println(player.getHandValue());					
		
		player.addCardToHand(deck.nextCard());
		player.addCardToHand(deck.nextCard());

		out.println("\n\ntoString");
		out.println(player);	
		
		out.println("\n\nhandValue");
		out.println(player.getHandValue());									
	}
}