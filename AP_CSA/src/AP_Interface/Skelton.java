package AP_Interface;

public class Skelton implements Monster {
    private static final String name = "Mr. AP_Interface.Skelton";
    private int size;

    public Skelton(int s){
        size = s;
    }

    public int getHowBig(){
        return size;
    }

    public String getName(){
        return name;
    }

    public boolean isBigger(Monster other){
        return size > other.getHowBig();
    }

    public boolean isSmaller(Monster other){
        return size < other.getHowBig();
    }

    public boolean namesTheSame(Monster other){
        return name.equals(other.getName());
    }


    public String toString(){
        return name + " " + size;
    }
}
