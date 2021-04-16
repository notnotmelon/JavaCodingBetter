import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Guang {
    public static void main(String[] args) throws IOException {
        Scanner arg = new Scanner(new File("2017S\\guang.dat"));
//        Scanner arg = new Scanner(new File("guang.dat"));

        String[] vals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        while (arg.hasNext()) {
            int val = arg.nextInt(), b = arg.nextInt();

            String res = "";

            while (val > 0) {
                int i = val % b;
                val /= b;
                res = vals[i] + res;
            }

            for (int i = 0; i < res.length(); i++) {
                System.out.print("0");
            }

            System.out.println(res);

        }

        arg.close();
    }
}
