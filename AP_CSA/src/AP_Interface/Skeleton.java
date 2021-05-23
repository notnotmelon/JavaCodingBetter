package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Skeleton implements Monster
{
	//add instance variables
    private String name;
    private int size;

	//add a constructor

    public Skeleton(String str, int s){
        name = str; size = s;
    }

	//add code to implement the AP_Interface.Monster interface

    public int getHowBig(){
        return size;
    }

    public String getName(){
        return name;
    }

    public boolean isBigger(Monster other){
        return size > other.getHowBig();
    }

    public boolean isSmaller(Monster other){
        return size < other.getHowBig();
    }

    public boolean namesTheSame(Monster other){
        return name.equals(other.getName());
    }

	//add a toString

    public String toString(){
        return name + " " + size;
    }
}