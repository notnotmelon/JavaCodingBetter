package AP_Interface;

public class VowelWord extends Word{
    private static String vows = "aeiou";

    public VowelWord(String s){
        super(s);
    }

    public int compareTo(VowelWord w){
        return vowCount(toString().split("")) != vowCount(w.toString().split("")) ?
                 vowCount(toString().split("")) - vowCount(w.toString().split("")) :
                toString().compareTo(w.toString()) ;
    }

    private int vowCount(String[] a){
        int cnt = 0;
        for(String j : a){
            if(vows.contains(j)){
                cnt++;
            }
        }
        return cnt;
    }
}
