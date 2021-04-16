package TwoNineTDistrict;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Botan {
public static void main(String[] args) throws IOException{
    Scanner arg = new Scanner(new File("2019D\\botan.dat"));
    int cases = arg.nextInt();
    int cnt = -cases;
    while(cases --> 0){
//        String num = "" + arg.nextInt();
        int num = arg.nextInt();

        boolean bot = botanPrime(num);

        System.out.print("Case #"+ Math.abs(cnt + cases) +": ");

        if(bot){
            System.out.println("BOTAN-PRIME");
        }else{
            System.out.println("NOT BOTAN-PRIME");
        }
    }

//    System.out.printf("Case #%d: %d - %s%n", caseNum, num,output);

    arg.close();
}

public static boolean botanPrime(int num){
//    if(num.length() <= 1){
//        return isPrime(Integer.parseInt(num));
//    }
//    for(int i = num.length()-1; i >= 0 ; i--){
//        for(int j = i; j < num.length(); j++){
////            String sub = Integer.parseInt(num.substring(i, j));
//            String sub = num.substring(i, j);
//            if(!botanPrime(sub)){
//                return false;
//            }
//        }
//    }
//
//    return true;

//    isPrime |= p == lastDigit;
    boolean botan = true;

    while(num > 0){
        int tem = num % 10;
        botan &= isPrime(tem);
        num /= 10;
    }
    return botan;
}

public static boolean isPrime(int x){
    if(x <= 1){
        return false;
    }

    for(int i = 2; i < x; i++){
        if( ((float) x) / i == (float)(x / i) ){
            return false;
        }
    }

    return true;
}
}