package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Sarah {
//    public static char[] vow = {'a','e','i','o','u'};

    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\sarah.dat"));

        //area
        //raea
        //eara
        //aare

        while (arg.hasNext()){
             String orig = arg.next(), bruh = orig;

             if(bruh.length() > 1){
                 bruh = ruled(bruh);
             }

             System.out.println(orig + " "+bruh);
        }

        arg.close();
    }

    public static String ruled(String x){
//        if( (x.charAt(0) + "").matches("[aeiou]") ){
//            x = x.charAt(1) + x.charAt(0) + x.substring(2);
//        }
//
//        for(int i = 1; i<x.length()-2; i++){
//            if( (x.charAt(i) + "").matches("[aeiou]") ){
//                x = x.charAt(1) + x.charAt(0) + x.substring(2);
//            }
//        }
//
//        if( (x.charAt(x.length()-1) + "").matches("[aeiou]") ){
//            x = x.charAt(x.length()-1) + x.substring(1, x.length() - 1) + x.charAt(0);
//        }
        String[] y = x.split("");

        if(y[0].matches("[aeiou]")){
            swap(y,0,1);
        }

        for(int i = 1; i<y.length-1; i++){
            if(y[i].matches("[aeiou]")){
                swap(y,i-1,i+1);
            }
        }

        if(y[y.length-1].matches("[aeiou]")){
            swap(y, y.length-1, 0);
        }

        x="";
        for(String j: y){
            x+=j;
        }

        return x;
    }

    public static void swap(String[] bruh, int a, int b){
        String t = bruh[a];
        bruh[a] = bruh[b];
        bruh[b] = t;
    }
}
