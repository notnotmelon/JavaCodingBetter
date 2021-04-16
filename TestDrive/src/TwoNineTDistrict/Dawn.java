package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dawn {
    public static void main (String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\dawn.dat"));

        int cases = arg.nextInt();

        double totalIn = 0, totalMo = 0, totalY = 0, totalPr = 0;

        System.out.println("     Amount                             Monthly          Total");
        System.out.println("....Invested........APR......Years......Payment.........Payments............Profit..");

        while(cases --> 0){
            double amt = arg.nextDouble(), apr = arg.nextDouble();

            totalIn += amt;

            int year = arg.nextInt();

            double mI = apr / 1200.0;
            //maybe just good practice to use floatings on floatings

            double pay = Math.round( (amt*mI)/(1 - Math.pow(1+mI, -year * 12)) * 100 ) / 100.0;
            double total = pay*12*year;
            double profit = total - amt;

            totalMo += pay;
            totalY += total;
            totalPr += profit;

//            System.out.println(amt + "\n" + apr+ "\n" +year+ "\n" +pay+ "\n" +total);
//            System.out.printf();
            System.out.printf("$%,12.2f  |  %6.3f%%  |   %2d  |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n", amt, apr, year, pay, total, profit);
        }

//        out.printf("$%,12.2f  |  %6.3f%%  |   %2d  |  $%,9.2f  |  $%,12.2f  |  $%,12.2f\n",
//                inheritance, apr, years, payment, value, profit);
        arg.close();
        System.out.printf("$%,12.2f  |           |       |  $%,9.2f  |  $%,12.2f  |  $%,12.2f", totalIn, totalMo, totalY, totalPr);
    }
}
