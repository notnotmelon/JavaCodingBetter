import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
used solution extensively, also on Christina
 */

public class Dai {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2017S\\dai.dat"));
//        Scanner arg = new Scanner(new File("dai.dat"));

        int cases = arg.nextInt();

        arg.nextLine();

        while(cases --> 0){
            ArrayList<Pair> pts = new ArrayList<>();

            Scanner nums = new Scanner(arg.nextLine());

            while(nums.hasNextInt()){
                pts.add(new Pair(nums.nextInt(), nums.nextInt()));
            }

            nums.close();

            ArrayList<Line> lines = new ArrayList<>();

            for(int i = 0; i<pts.size(); i+=2){
                Pair a = pts.get(i), b = pts.get(i+1);

                Line l = new Line();
                l.j = a;
                l.k = b;

                l.m = (b.y - a.y)/(b.x - a.x);
                l.b = b.y - l.m * b.x;

                lines.add(l);
            }

            ArrayList<Intersection> inter = new ArrayList<Intersection>();

            for(int i = 0; i<lines.size(); i++){
                for(int j = i + 1; j<lines.size(); j++){
//                    if(i == j){continue;}

                    Line a = lines.get(i), b = lines.get(j);
                    double y = (b.b-a.b)/(a.m - b.m);

                    Pair x = new Pair(y, a.m * y + a.b);

                    if(intersect(x, a.j, a.k) && intersect(x, b.j, b.k)){
                        inter.add(new Intersection(a, b, x));
                    }
                }
            }

            if(inter.size() == 0){
                System.out.println(0);
                continue;
            }

            Line yeo = inter.get(0).b, cur = inter.get(0).b;
            ArrayList<Line> poly = new ArrayList<Line>();

            for(int i = 0; i<inter.size(); i++){
                for(Intersection j : inter){
                    if(cur == j.a && !poly.contains(cur)){
                        poly.add(cur);
                        cur = j.b;
                        continue;
                    }

                    if(cur == j.b && !poly.contains(cur)){
                        poly.add(cur);
                        cur = j.a;
                    }
                }
            }

            if(cur == yeo && poly.size() > 2){
                System.out.println(poly.size());
            }else{
                System.out.println(0);
            }
        }
    }

    public static boolean intersect(Pair x, Pair a, Pair b){
        if((Math.abs(x.x - a.x) < 0.001 && Math.abs(x.y - a.y) < 0.001) ||
                (Math.abs(x.x - b.x) < 0.001 && Math.abs(x.y - b.y) < 0.001)){
            return true;
        }

        double d = Math.sqrt( Math.pow(b.x - a.x,2) + Math.pow(b.y - a.y, 2) ),
        d1 = Math.sqrt(Math.pow(x.x - a.x, 2) + Math.pow(x.y - a.y, 2)),
        d2 = Math.sqrt(Math.pow(b.x - x.x, 2) + Math.pow(b.y - x.y, 2));

        return d1 <= d && d2 <= d;
    }
}

class Pair{
    double x, y;

    public Pair(double a, double b){
        x = a;
        y = b;
    }

//    public
}

class Line{
    double m, b;
    Pair j, k;
}

class Intersection{
    Line a, b;
    Pair c;

    public Intersection(Line a, Line b, Pair c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}