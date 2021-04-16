package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Tammy {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\tammy.dat"));

        int cases = arg.nextInt();

        while(cases --> 0){
            int vert = arg.nextInt(), edge = arg.nextInt(), cnt = vert;

            int[] gr = new int[vert];

            for(int i = 0; i<vert; i++){gr[i] = i;}

            for(int i = 0; i<edge; i++){
                int x = arg.nextInt() - 1, y = arg.nextInt() - 1;

                cnt -= merge(gr, x, y);
            }

            if(cnt == vert){
                System.out.println("1, 1");
            }else{
                long ways = cnt > 0 ? (long) Math.pow(2, cnt) : 1L;

//                long ways = 1;
//                for(int i = 0; i<cnt; i++){
//                    ways *= 2;
//                }

                System.out.println("2, " + ways);
            }
        }
    }

    public static int find(int[] bruh, int c){
//        return bruh [c] = c == bruh[c] ? c : find(bruh, bruh[c]);
        return c == bruh[c] ? c : find(bruh, bruh[c]);
    }

    public static int merge(int[] bruh, int a, int b){
        int r1 = find(bruh, a), r2 = find(bruh, b);
        if(r1 == r2){
            return 0;
        }

        bruh[r1] = r2;
        return 1;
    }
}
