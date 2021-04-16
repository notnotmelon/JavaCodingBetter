package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Rajeev {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2019D\\rajeev.dat"));

        while(arg.hasNext()){
            String[] bruh = arg.nextLine().split(",");
            boolean leak = false;
            for(int i = 2; i<bruh.length; i++){
                if(!bruh[i].matches("(.*)@uiltexas\\.org") && !bruh[i].matches("(.*)@uil\\.net")){
                    leak = true;
                    break;
                }
            }

            if(leak){
                System.out.print(bruh[0]+": "+bruh[1]);
                for(int i = 2; i<bruh.length; i++){
                    if(!bruh[i].matches("(.*)@uiltexas\\.org") && !bruh[i].matches("(.*)@uil\\.net")) {
                        System.out.print(": " + bruh[i]);
                    }
                }
                System.out.println();
            }
        }

        arg.close();
    }
}
