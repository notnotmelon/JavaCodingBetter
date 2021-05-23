package AP_Abstract_Golf;//www.apluscompsci.com
//Name -

import static java.lang.System.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Golf
{
	//add in AP_Abstract_Golf.Player instance variable
//	private AP_Abstract_Golf.Player p1, p2;
	private Player[] players;
	//add in Dealer instance variable
	private Deck deck;
	//max handsize, times player can swap
	private int hS, sT;

	private static Scanner keb;

	public Golf()
	{
		keb = new Scanner(System.in);

		deck = new Deck();
		deck.shuffle();

		out.println("How many Players do you want? [2-52]");
		players = new Player[getPlayerInt(2,52)];

		out.println("How many will be people?");
		int numP = getPlayerInt(0, players.length);

		for(int i = 0; i< players.length; i++){
			if(i<numP){
				out.println("Input this player's name: ");
				players[i] = new Player(keb.next());
			}else{
				players[i] = new GolfComputerPlayer("Auto "+(i+1));
			}
		}
	}

	public void playGame()
	{
		char choice;

		do{
			out.println("What will the hand size be? [1 - 52]");
			hS = getPlayerInt(1, 52);

			out.println("How many cards can the Players swap out? [1 - 52]");
			sT = getPlayerInt(1,52);

			for(Player j : players){
				if(j instanceof GolfComputerPlayer){
					out.println("What is the highest acceptable value of card for Computers to have? [1 - 10]");
					GolfComputerPlayer.setLowValue(getPlayerInt(1, 10));
					keb.nextLine();
					break;
				}
			}

			for(Player j : players){
				j.resetHand();
			}

			if(deck.numCardsLeft() < (hS + sT) * players.length){
				deck.shuffle();
			}

			while(players[0].getHandSize() < hS){
				for(Player j : players){
					j.addCardToHand(deck.nextCard());
				}
			}

			for(Player j : players){

				out.println("Press enter to go.");
				keb.nextLine();

//				out.println(j.getName()+": Hand Value - "+j.getHandValue());
				if(j instanceof GolfComputerPlayer){
					computerSwap( (GolfComputerPlayer) j);
				}else{
					playerSwap(j);
				}
			}

//			out.println("AP_Abstract_Golf.Player 1:\nHand Value - "+p1.getHandValue()+"\nHand Size - "+p1.getHandSize()+"\n");
//			playerSwap(p1);
//
//			out.println("AP_Abstract_Golf.Player 2:\nHand Value - "+p2.getHandValue()+"\nHand Size - "+p2.getHandSize()+"\n");
//			playerSwap(p2);

			Player win = players[0];
			boolean draw = false;

			for(int i = 1; i<players.length; i++){
				if(win.getHandValue() > players[i].getHandValue()){
					win = players[i];
					draw = false;
				}else if(win.getHandValue() == players[i].getHandValue()){
					draw = true;
				}
			}
			if(draw){
				out.println("Draw!\n");
			}else{
				upWinCnt(win);
			}

			for(Player j : players){
				out.println(j.getName()+"\nPoints: "+j.getHandValue()+"\nScore: "+j.getWinCount()+"\n");
			}

			out.println("Would you like to play again? [Y, N]");
			choice = keb.next().toLowerCase().charAt(0);
		}while(choice == 'y');
	}
	
	public static void main(String[] args)
	{
		Golf game = new Golf();
		game.playGame();
		keb.close();
	}

	public void upWinCnt(Player p){
		p.setWinCount( p.getWinCount() + 1);
		out.println(p.getName() + " wins!");
	}

	public int getPlayerInt(int bot, int top){
		int numP;
		do{
			try{
				numP = keb.nextInt();
			}catch (InputMismatchException e){
				numP = -1;
			}
		}while(numP < bot || numP > top);

		return numP;
	}

	public void computerSwap(GolfComputerPlayer p){
		out.println(p+"\n"+p.getName()+" will now go. [Enter]");
		//amount of swaps taken
		int cnt = 0;

		keb.nextLine();

		while(p.shouldSwap() && cnt < sT){
			p.swapCards(p.indexOfHigh(), deck.nextCard());
			cnt++;
		}

		out.println(p.getName()+" swapped "+cnt+" time(s)\n"+p+"\n[Enter to continue]");
		keb.nextLine();
	}

	public void playerSwap(Player p){
		int index;
		char c;
		for(int i = 0; i<sT; i++){
			out.println(p+"\n\nYou can swap out "+(sT - i)+" more card(s). [Yes, No]");

			do{
				c = keb.next().toLowerCase().charAt(0);
			}while(c != 'y' && c != 'n');

			if(c == 'y'){
				Card bruh = deck.nextCard();
				out.println("Select a card to swap, 0 - "+ (p.getHandSize() - 1) );
				do{
					try{
						index = keb.nextInt();
					}catch(InputMismatchException e){
						index = -1;
					}
					keb.nextLine();
				}while(p.swapCards(index, bruh) == -1);
			}else{
				break;
			}
			out.println();
		}

		out.println(p+"\n[Enter to continue]");
		keb.nextLine();
	}
}