import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Melissa {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arg = new Scanner(new File("melissa.dat"));

        int cases = arg.nextInt();

        while(cases --> 0){
            int num = arg.nextInt();

            System.out.print(num + " -> ");

            while(num >= 10){
                num = trans(num);
            }

            System.out.println(num);
        }
    }

    public static int trans(int a){
        int b = 1;
        while(a > 0){
            b *= a%10 > 0 ? a%10 : 1;
            a /= 10;
        }
        return b;
    }
}
