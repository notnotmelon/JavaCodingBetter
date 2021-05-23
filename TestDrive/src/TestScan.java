import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestScan /*implements Comparable<>*/ {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arg = new Scanner(new File("test_YTP.txt"));

        int cnt = 0;

        while(arg.hasNext()){
            if(arg.next().contains("Dick")){
                cnt++;
            }
        }

        System.out.print(cnt);

        Queue<Integer> bruh = new LinkedList<>();
        //bruh = new Queue<Integer>();

        bruh.offer(10);

        Set<Integer> yeow = new HashSet<Integer>();

        String dude = "dude";

        System.out.println(dude.substring(0,0));
    }
}
