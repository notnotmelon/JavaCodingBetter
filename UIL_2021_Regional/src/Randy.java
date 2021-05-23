import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Randy {
    static char[] f;

    public static void main(String[] args) throws IOException{
        Scanner arg = new Scanner(new File("randy.dat"));
        int cases = arg.nextInt();
        arg.nextLine();
        while(cases --> 0){
            f = arg.nextLine().toCharArray();
            //first 9 frames
            int scr = 0, l = 18;

            for(int i = 0; i<l; i++){
                switch(f[i]){
                    case('X'):
                        l--;
                        //# of > pins <
                        scr+=guessCalc(i+2) + calcVal(f[i+1]) + calcVal(f[i]);
                        break;
                    case('/'):
                        //frames = groups of 2
                        scr+=spCalc(i)+calcVal(f[i+1]);
                        break;
                    default:
                        scr+=calcVal(f[i]);
                        break;
                }
            }
            //10th frame
            for(int i = l; i<f.length; i++){
                if(f[i] == '/'){
                    scr += spCalc(i);
                }else{
                    scr += calcVal(f[i]);
                }
            }

            System.out.println(scr);
        }
        arg.close();
    }

//    public static int strike(int i){
//        return spare(i) + calcVal(f[i+2]);
//    }
//    public static int spare(int i){
//        return calcVal(f[i]) + calcVal(f[i+1]);
//    }
    public static int guessCalc(int i){
        if(f[i] == '/'){
            return spCalc(i);
        }else {
            return calcVal(f[i]);
        }
    }

    public static int spCalc(int i){
        return 10 - calcVal(f[i-1]);
    }

    public static int calcVal(char x){
        int cnt = 0;
        switch(x){
            case('X'):
            case('/'):
                cnt++;
            case('9'):
                cnt++;
            case('8'):
                cnt++;
            case('7'):
                cnt++;
            case('6'):
                cnt++;
            case('5'):
                cnt++;
            case('4'):
                cnt++;
            case('3'):
                cnt++;
            case('2'):
                cnt++;
            case('1'):
                cnt++;
            default:
                return cnt;
        }
    }
}
