package AP_Abstract_Golf;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors

	public Card(){
		setSuit("SPADES");
		setFace(0);
	}

	public Card(String s){
		setSuit(s);
	}

	public Card(int f){
		setFace(f);
	}

	public Card(int f, String s){
		setSuit(s);
		setFace(f);
	}

	// modifiers

	public void setSuit(String s){
		suit = s;
	}

	public void setFace(int f){
		face = f;
	}

  	//accessors

	public int getFace(){
		return face;
	}

	public String getSuit(){
		return suit;
	}

  	public abstract int getValue();

	public boolean equals(Object obj)
	{
		return getSuit().equals( ((Card) obj).getSuit() ) && getFace() == ((Card) obj).getFace();
	}

  	//toString

	public String toString(){
		return FACES[face] + " of " + suit + " | value = " + getValue();
	}
 }