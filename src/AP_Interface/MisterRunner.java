package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class MisterRunner
{
   public static void main( String args[] )
   {
		Mister zero = new Mister();
		Mister one = new Mister(8);
		Mister sue = new Mister(9, 4);
		Mister harry = new Mister(1, 2, 3);
		out.println("\nzero AP_Interface.Mister :: " + zero);
		out.println("\none AP_Interface.Mister :: " + one);
		out.println("\nsue AP_Interface.Mister :: " + sue);
		out.println("\nharry AP_Interface.Mister :: " + harry);

		out.println("\nchanging harry's properties ");				
		harry.setHeight(7);
		harry.setWeight(6);
		harry.setAge(5);
		out.println("\nharry AP_Interface.Mister :: " + harry);

		out.println("\ncloning harry");	
		sue = (Mister)harry.clone();
		out.println("\nsue AP_Interface.Monster :: " + sue);

		Mister mOne = new Mister(33,33,11);
		Mister mTwo = new Mister(55,33,11);

		out.println("\nAP_Interface.Mister 1 :: " + mOne);
		out.println("\nAP_Interface.Mister 2 :: " + mTwo);

		out.print("\nmOne.equals(mTwo) == ");
		out.println(mOne.equals(mTwo));

		out.print("\nmOne.compareTo(mTwo) == ");
		out.println(mOne.compareTo(mTwo));
		out.print("\nmTwo.compareTo(mOne) == ");
		out.println(mTwo.compareTo(mOne));
	}
}