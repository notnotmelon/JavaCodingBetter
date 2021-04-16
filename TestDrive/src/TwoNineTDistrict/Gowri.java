package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Gowri {
    public static void main (String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\gowri.dat"));

        int cases = arg.nextInt();
        while(cases --> 0){
            cutSquare(arg.nextInt());
        }

        arg.close();
    }

    public static void cutSquare(int x){
        String top = "    "+makeStr(x,"*")+"    ";
        System.out.println(top);

        System.out.println("   *"+makeStr(x, " ")+"*   ");
        System.out.println("  * "+makeStr(x, " ")+" *  ");
        System.out.println(" *  "+makeStr(x, " ")+"  * ");

        for(int i = 0; i<x; i++){
            System.out.println("*"+makeStr(x+6, " ")+"*");
        }

        System.out.println(" *  "+makeStr(x, " ")+"  * ");
        System.out.println("  * "+makeStr(x, " ")+" *  ");
        System.out.println("   *"+makeStr(x, " ")+"*   ");

        System.out.println(top+"\n--------------------");
    }

    public static String makeStr(int x, String r){
        String bruh = "";
        for(int i = 0; i<x; i++){
            bruh += r;
        }
        return bruh;
    }
}
