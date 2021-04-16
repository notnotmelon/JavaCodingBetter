import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Harish {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arg = new Scanner(new File("harish.dat"));

        int cases = arg.nextInt();

        arg.nextLine();

        while(cases > 0){
            int cnt = 0;
            //arg.nextLine();

            String[][] dude = new String[5][5];

            boolean val = true;

            for(int i = 0; i<5; i++){
                dude[i] = arg.nextLine().split("");
            }

            //System.out.print(dude[0][0]);

            for(int y = 0; y<dude.length; y++){
                for(int x = 0; x<dude[y].length; x++){
                    if(dude[y][x].equals("a")){
                        cnt++;
                        val = check(dude, x, y);
                    }
                    if(!val){break;}
                }
                if(!val){break;}
            }

            if(val || cnt == 9){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }

            arg.nextLine();

            cases--;
        }

        arg.close();
    }

    public static boolean check(String[][] mat, int x, int y){
        if(!(x-2 < 0)){
            if(!(y - 2 < 0)){
                if(mat[y-2][x-2].equals("a")){
                    return false;
                }
            }
            if(!(y + 2 >= mat.length)){
                if(mat[y+2][x-2].equals("a")){
                    return false;
                }
            }
        }

        if(!(x+2 >= mat.length)){
            if(! (y - 2 < 0)){
                if(mat[y-2][x+2].equals("a")){
                    return false;
                }
            }
            if(! (y + 2 >= mat.length)){
                if(mat[y+2][x+2].equals("a")){
                    return false;
                }
            }
        }
        return true;
    }
}
