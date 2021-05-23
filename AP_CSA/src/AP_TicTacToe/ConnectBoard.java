package AP_TicTacToe;

public class ConnectBoard extends GameBoard{

    public ConnectBoard(){
        super(6,7,4);
    }

//    @Override
    public void markBoard() {
        super.markBoard();

        Grid b = getBoard();

        for(int y = 0; y<b.getNumRows()-1; y++){
            for(int x = 0; x<b.getNumCols(); x++){
                if(b.getSpot(y,x) != null && b.getSpot(y+1, x) == null){
                    b.setSpot(y+1, x, b.getSpot(y, x) );
                    b.setSpot(y, x, null);
                    b.getSpot(y+1,x).setPos(55+x*50, 5+(y+1)*50+50);
                }

            }
        }
    }
}
