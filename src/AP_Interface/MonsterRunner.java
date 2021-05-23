package AP_Interface;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keb = new Scanner(System.in);
		
		//ask for name and size
		System.out.println("Name: ");
		String str = keb.nextLine();
		System.out.println("Size: ");
		int num = keb.nextInt(); keb.nextLine();
		
		//instantiate monster one
		Monster bruh = new Skeleton(str, num);
		
		//ask for name and size
		System.out.println("Name: ");
		str = keb.nextLine();
		System.out.println("Size: ");
		num = keb.nextInt(); keb.nextLine();
		
		//instantiate monster two
		Monster yarg = new Skeleton(str, num);

		System.out.println("Size: ");
		num = keb.nextInt();

		Monster why = new Skelton(num);

		System.out.println("AP_Interface.Monster 1: "+bruh+"\nAP_Interface.Monster 2: "+yarg+"\nManster 1 :"+why);

		out.println("AP_Interface.Monster 1 is bigger than AP_Interface.Monster 2: "+bruh.isBigger(yarg));
		out.println("Manster 1 is smaller than AP_Interface.Monster 1: "+why.isSmaller(bruh));
		out.println("AP_Interface.Monster 2 has the same name as Manster 1: "+yarg.namesTheSame(why));
	}
}