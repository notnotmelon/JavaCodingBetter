import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Changpu {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2017S\\changpu.dat"));
//        Scanner arg = new Scanner(new File("changpu.dat"));

        while(arg.hasNextInt()){
            int num = arg.nextInt(), nxt = num % 2 == 0 ? ~num : -num;
            System.out.println(num + " " + nxt);
        }

        arg.close();
    }
}
