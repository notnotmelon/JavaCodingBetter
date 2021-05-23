package AP_TicTacToe;

import javax.swing.*;

public class ConnectWhatever extends JFrame {
    public static final int WIDTH = 850, HEIGHT = 625;

    public ConnectWhatever(){
        super("BIT CONNECT");
        setSize(WIDTH,HEIGHT);

        getContentPane().add(new ConnectBoard());

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        ConnectWhatever game = new ConnectWhatever();
    }
}
