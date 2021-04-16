import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Christina {
    public static void main(String[] args) throws IOException {
        Scanner arg = new Scanner(new File("2017S\\christina.dat"));
//        Scanner arg = new Scanner(new File("christina.dat"));

//        int cases = arg.nextInt();
        String[] names = new String[arg.nextInt()];

        arg.nextLine();

        for(int i = 0; i<names.length; i++){
            names[i] = arg.nextLine();
        }

//        Scanner nxt;
        String nxt;

        while(arg.hasNext()){
//            nxt = new Scanner(arg.nextLine());
            nxt = arg.nextLine();

            while(!nxt.equals("")){
                int i = Integer.parseInt(nxt.substring(0,2)) - 1;

//                nxt = nxt.substring(2);

                String res = names[i];

                char style = nxt.charAt(2);
                nxt = nxt.substring(3);

                switch(style){
                    case('u'):
                        res = new String( new StringBuilder(res).reverse() );
                    case('U'):
                        res = res.toUpperCase();
                        break;
                    case('l'):
                        res = new String( new StringBuilder(res).reverse() );
                    case('L'):
                        res = res.toLowerCase();
                        break;
                    case('r'):
                        res = new String( new StringBuilder(res).reverse() );
                        break;
                    default:
                        break;
                }

                System.out.print(res);
            }

            System.out.println();
        }

        arg.close();
    }
}
