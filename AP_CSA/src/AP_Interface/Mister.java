package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Mister implements Comparable
{
	private int height, weight, age;

	//write a default Constructor

	public Mister(){
		this(90);
	}

	public Mister(int ht){
		this(ht, 110);
	}

	public Mister(int ht, int wt){
		this(ht, wt, 21);
	}

	public Mister(int ht, int wt, int age){
		height = ht;
		weight = wt;
		this.age = age;
	}

	//modifiers - write set methods for height, weight, and age

	public void setHeight(int num){
		height = num;
	}

	public void setWeight(int num){
		weight = num;
	}

	public void setAge(int num){
		age = num;
	}
	
	//accessors - write get methods for height, weight, and age
	
	public int getHeight(){
		return height;
	}

	public int getWeight(){
		return weight;
	}

	public int getAge(){
		return age;
	}
	
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Mister(height, weight, age);
	}

	public boolean equals( Object obj )
	{
		return height == ((Mister) obj).getHeight() && weight == ((Mister) obj).getWeight() && age == ((Mister) obj).getAge()  ;
	}

	public int compareTo( Object obj )
	{
		Mister rhs = (Mister)obj;
		int a, b;

		if(height == rhs.getHeight()){
			if(weight == rhs.getWeight()){
				if(age == rhs.getAge()){
					return 0;
				}
				a = age;
				b = rhs.getAge();
			}else{
				a = weight;
				b = rhs.getWeight();
			}
		}else{
			a = height;
			b = rhs.getHeight();
		}

		return a > b ? 1 : -1;
	}

	//write a toString() method
	
	public String toString(){
		return "Height: "+height+"\tWeight: "+weight+"\tAge: "+age;
	}
}