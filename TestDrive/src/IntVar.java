public class IntVar {
    public int Val;

    public IntVar(){

    }

    public void setVal(int v){
        Val = v;
    }

    public void setVal(IntVar v){
        Val = v.getVal();
    }

    public int getVal(){
        return Val;
    }
}
