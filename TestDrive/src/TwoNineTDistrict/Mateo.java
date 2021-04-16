package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Mateo {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\mateo.dat"));

        while(arg.hasNextDouble()){
            double x1 = arg.nextDouble(), x2 = arg.nextDouble();
            double x = x1 > x2 ? x2 : x1;
            x2 = x1 > x2 ? x1 : x2;
            x1 = x;

            double y1 = doEquat(x1), y2 = doEquat(x2);

            if(y1 * y2 > 0){
//            if((y1 > 0 && y2 > 0) || (y1 < 0 && y2 < 0)){
                System.out.println("UNDEFINED");
            }else{
                x = (x1 + x2)/2.0;
                double y = doEquat(x);

                while(checkF(y)){
                    if(y * doEquat(x1) > 0){
                        x1 = x;
                    }else{x2 = x;}

                    x = (x1+x2)/2.0;
                    y = doEquat(x);
                }
                System.out.printf("%9.7f\n", x);
            }
        }

        arg.close();
    }

    public static double doEquat(double x){
        return 1.3 * Math.pow(x, 4.0) - 35.1 * Math.pow(x, 2.0) - 18.2*x + 89.7;
    }

    public static boolean checkF(double x){
        //return x > -.0000001 && x < .0000001;
        return Math.abs(x) > .0000001;
    }
}
