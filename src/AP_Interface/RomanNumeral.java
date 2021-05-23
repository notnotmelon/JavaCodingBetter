package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class RomanNumeral implements Comparable<RomanNumeral>
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		roman = str;
		setNumber(str);
	}

	public RomanNumeral(Integer orig)
	{
		number  = orig;
		setRoman(orig);
	}

	//write a set number method
	
	public void setNumber(Integer num){
		number = num;
		setRoman(num);
	}

	public void setNumber(String r){
		number = 0;
		if(r.contains("0")){return;}
		for(int i = 0; i < r.length()-1; i++){
//			if(getValue(r.charAt(i)+"") < getValue(r.charAt(i+1)+"") ){
//				number -= getValue(r.charAt(i)+"");
//			}
			number += getValue(r.charAt(i)+"") < getValue(r.charAt(i+1)+"") ?
					-getValue(r.charAt(i)+"") : getValue(r.charAt(i)+"");
		}
		number += getValue(r.charAt(r.length()-1)+"");
	}

	private static int getValue(String x){
		for(int i = 0; i<LETTERS.length; i+=2){
			if(LETTERS[i].equals(x)){
				return NUMBERS[i];
			}
		}
		return 0;
	}
	
	//write a set roman method

	public void setRoman(String r){
		roman = r;
		setNumber(r);
	}

	public void setRoman(int num){
		if(num == 0){roman = "0";}
		else{
			roman = "";
			for(int i = 0; i<NUMBERS.length; i++){
				while(num - NUMBERS[i] >= 0){
					if(LETTERS[i].length() > 1 && roman.indexOf(LETTERS[i-1]) != -1){
						roman = roman.substring(0, roman.indexOf(LETTERS[i-1])) + LETTERS[i] +
								roman.substring(roman.indexOf(LETTERS[i-1]));
					}else{
						roman += LETTERS[i];
					}
					num -= NUMBERS[i];
				}
				//alt
				/*
				int amt = num / NUMBERS[i]
				for(in j < amt){
				 if(LETTERS > 1){
				  roman = substring;
				  else{
				  roman += letters
				}

				num %= NUMBERS[i]
				 */
			}
		}
	}

	//write get methods for number and roman
	
	public Integer getNumber(){
		return number;
	}

	public String getRoman(){
		return roman;
	}

	public int compareTo(RomanNumeral r)
	{
		return number - r.getNumber();
	}

	public boolean equals(RomanNumeral r){return compareTo(r) == 0;}

	//write  toString() method
	
	public String toString(){
		return getRoman();
	}
	
}