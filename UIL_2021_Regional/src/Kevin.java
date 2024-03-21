import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This Java program is designed to read data from a file
 * named "kevin.dat" and perform some calculations on it.
 * The data is expected to be in a specific format, with each line 
 *containing an integer month, an integer day, a double distance, and three integers representing hours, minutes, and seconds.
 */

public class Kevin {
    public static void main(String[] args)throws IOException{
        Scanner arg = new Scanner(new File("kevin.dat"));

        ArrayList<Log> bruh = new ArrayList<>();

        while(arg.hasNextInt()){
            int month = arg.nextInt(), day = arg.nextInt();
            double dist = arg.nextDouble();
            int hrs = arg.nextInt(), min = arg.nextInt(), sec = arg.nextInt();

            bruh.add(new Log(month, day, hrs, min, sec, dist));
        }

        double totDis = 0;
        int totHrs = 0, totMin = 0, totSec = 0;

        for(Log j : bruh){
            totDis += j.dist;
            totHrs += j.hrs;
            totMin += j.min;
            totSec += j.sec;
        }
        double avgDis = totDis/bruh.size();

        int tempT = (totHrs*3600 + totMin*60 + totSec)/bruh.size() ;

        totMin += totSec / 60;
        totSec %= 60;
        totHrs += totMin/60;
        totMin %=60;

        int avgMin = tempT / 60;
        int avgSec = tempT % 60;
        int avgHrs = avgMin / 60;
        avgMin %= 60;

//        System.out.println("TD")

        
    }
}

class Log{
    public int month, day, hrs, min, sec;
    public double dist;

    public Log(){}

    public Log(int y, int d, int h, int m, int s, double l){
        month = y;
        day = d;
        hrs = h;
        min = m;
        sec = s;
        dist = l;
    }

    //0 = short, 1 = med, 2 = long

}