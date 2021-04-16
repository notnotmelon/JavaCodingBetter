package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Egor {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\egor.dat"));

//        int cases = arg.nextInt();
//
//        while(cases --> 0){
//            String nxt = arg.next();
//            arg.nextLine();
//        }

        ArrayList<String> names = new ArrayList<String>();

//        while(arg.hasNext("^(?=.{5})^(?!.{8})^(?!.*[cmoy])^(?!.*ph)^[^N-Z].*$")){
//            names.add(arg.next("^(?=.{5})^(?!.{8})^(?!.*[cmoy])^(?!.*ph)^[^n-z].*$"));
//        }

        while(arg.hasNext()){
            String bruh = arg.nextLine();

            if(bruh.toLowerCase().matches("^(?=.{5})^(?!.{8})^(?!.*[cmoy])^(?!.*ph)^[^n-z].*$")){
                names.add(bruh);
            }
        }

        //https://stackoverflow.com/questions/24232515/regex-how-to-ignore-order-of-the-matched-groups

        Collections.sort(names);

        for(String j : names){
            System.out.println(j);
        }

        arg.close();

        //regexr.com
        // ^[^N-Z].{5,8}(?!ph).*$
        //^[^N-Z][^cmoy](?!ph).*$
        //"abcdefghijklm"
    }
}
