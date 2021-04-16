package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Luciano {
    public static void main(String[] args) throws IOException {
        Scanner arg = new Scanner(new File("2019D\\luciano.dat"));

        int cases = arg.nextInt();
        arg.nextLine();

        String[] bub = new String[cases];
        String[] sel = new String[cases];

        for(int i = 0; i < cases; i++){
            bub[i] = arg.nextLine();
            sel[i] = bub[i];
        }

        RevBubble(bub);
        Selection(sel);

        System.out.printf("%-20s:%-20s\n", "Selection Sort", "Bubble Sort (Rev)");

        for(int i = 0; i<cases; i++){
            System.out.printf("%-20s:%-20s\n", sel[i], bub[i]);
        }
    }

    public static void RevBubble(String[] bruh){
        for(int i = 0; i<10; i++){
            for (int j = bruh.length-1; j>0; j--){
                if(bruh[j].compareTo(bruh[j-1]) < 0){
                    swap(bruh, j, j-1);
                }
            }
        }
    }

    public static void Selection(String[] bruh){
        for(int i = 0; i< 10; i++){
            int hold = i;
            for(int j = i+1; j<bruh.length; j++){
                if(bruh[hold].compareTo(bruh[j]) > 0){
                    hold = j;
                }
            }
            swap(bruh, hold, i);
        }

        //String compareTo tring == String <>= tring
    }

    public static void swap(String[] bruh, int a, int b){
        String t = bruh[a];
        bruh[a] = bruh[b];
        bruh[b] = t;
    }
}
