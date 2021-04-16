import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DryRun {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("dryrun.dat"));

        int cases = arg.nextInt(); arg.nextLine();

        while(cases --> 0){
            System.out.println("I like "+arg.nextLine()+".");
        }

        arg.close();
    }
}
