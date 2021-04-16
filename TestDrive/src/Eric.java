import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Eric {
    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("2017S\\eric.dat"));
//        Scanner arg = new Scanner(new File("eric.dat"));

        while(arg.hasNextInt()){
            int a = arg.nextInt(), b = arg.nextInt(), x = a, y = b, cnt = 0, temp;

            do {
                temp = y;
                y = (x + y) % 10;
                x = temp;
                cnt++;
//            }while(x != a || y != b);
            }while(!(x == a && y == b));

            System.out.println(cnt + 2);
        }

        arg.close();
    }
}
