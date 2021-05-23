package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Word implements Comparable<Word>
{
	private String word;

	public Word(){
		word = "";
	}

	public Word( String s )
	{
		word = s;
	}

	public int compareTo( Word rhs )
	{		
		return word.length() != rhs.toString().length() ?
				word.length() - rhs.toString().length(): word.compareToIgnoreCase(rhs.toString());
	}

	public String toString()
	{
		return word;
	}
}