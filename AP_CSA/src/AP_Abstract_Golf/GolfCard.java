package AP_Abstract_Golf;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class GolfCard extends Card
{
  	//constructors

	public GolfCard(){
		super();
	}

	public GolfCard(String s){
		super(s);
	}

	public GolfCard(int f){
		super(f);
	}

	public GolfCard(int f, String s){
		super(f,s);
	}

  	public int getValue()
  	{
  		if(getFace() == 11){return 0;}
  		else{
  			return getFace() > 10 ? 10 : getFace();
		}
  	}  	
 }