import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DryRun {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arg = new Scanner(new File("dryrun.dat"));

        System.out.print(arg.next());
    }
}
