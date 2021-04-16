package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Banu {
    public static void main(String[] args) throws IOException {
        Scanner arg = new Scanner(new File("2019D\\banu.dat"));

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        while(arg.hasNextInt()){
            System.out.println(months[arg.nextInt()-1]);
        }
    }
}
