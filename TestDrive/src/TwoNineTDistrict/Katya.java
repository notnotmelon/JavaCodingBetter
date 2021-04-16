package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Katya {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\katya.dat"));

        int cases = arg.nextInt(), c = 0;

        while(c ++< cases){
            System.out.print(c+": ");
            int y1 = arg.nextInt(), x1 = arg.nextInt(), y2 = arg.nextInt(), x2 = arg.nextInt();

            arg.nextLine();

            if(x1 == y2){
                int[][] fin = new int[y1][x2];
                System.out.println(y1+", "+x2);

                String[][] a = new String[y1][];
                for(int i = 0; i<y1; i++){
                    a[i] = arg.nextLine().trim().split("\\s+");
                }

                String[][] b = new String[y2][];
                for(int i = 0; i<y2; i++){
                    b[i] = arg.nextLine().trim().split("\\s+");
                }

                for(int i = 0; i<fin.length; i++){
                    for(int j = 0; j<fin[i].length; j++){
                        fin[i][j] = sumProd(a,b,i,j);
                        System.out.printf("%5d", fin[i][j]);
                    }
                    System.out.print("\n");
                }

//                for(int[] i : fin){
//                    for(int j : i){
//                        System.out.printf("%5d", j);
//                    }
//                    System.out.print("\n");
//                }

            }else{
                System.out.println("SIZES NOT COMPATIBLE");
                for(int i = 0; i<y1+y2; i++){arg.nextLine();}
            }
            System.out.println("^^^^^^^^^^^^");
        }

        arg.close();
    }

    public static int sumProd(String[][] a, String[][] b, int y, int x){
        int sum = 0;

        for(int i = 0; i < a[y].length; i++){
//      for(String i : a[y]){
//            for(int j = 0; j<b.length; j++){
//                sum += a[y][i]*b[j][x];
//            }
//            for(String[] j : b){
//                sum += a[y][i] * j[x];
                sum += Integer.parseInt(a[y][i]) * Integer.parseInt(b[i][x]);
//            }
        }

        return sum;
    }
}
