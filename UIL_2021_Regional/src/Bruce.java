import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Bruce {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("bruce.dat"));

        int cases = arg.nextInt();
        while(cases --> 0){
            //sqrt only provides 1 side length
            System.out.printf("%.4f\n", Math.sqrt(arg.nextInt()) * 4);
        }
        arg.close();
    }
}
