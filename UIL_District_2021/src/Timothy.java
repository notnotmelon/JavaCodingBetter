import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Timothy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arg = new Scanner(new File("timothy.dat"));

        Map<Integer, Integer> mep = new HashMap<Integer, Integer>();

        int maxI = -1;

        while(arg.hasNextInt()){
            int num = arg.nextInt();

            if(maxI < num){maxI = num;}

            if(mep.containsKey(num)){
                mep.replace(num, mep.get(num) + 1);
            }else{
                mep.put(num, 0);
            }
        }

        while(maxI >= 0){
            if(mep.containsKey(maxI)){
                System.out.println(maxI + " " + (mep.get(maxI) == 0 ? "" : mep.get(maxI)));
            }
            maxI--;
        }
    }
}
