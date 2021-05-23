package AP_TicTacToe;//(c) A+ Computer Science
//www.apluscompsci.com
//Name - 

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GameBoard extends Canvas implements MouseListener
{
	private int mX, mY;
	private boolean mouseClicked, xTurn;
	private int mouseB;
	private Grid board;
	private String name;
	
//	private final static int WIDTH=150;
//	private final static int HEIGHT=150;
	private final static int SCALE = 50;
	//how many consecutive pieces are needed to win the game
	private static int WINLENGTH = 3;

	public GameBoard()
	{
		this(3);
		name = "TIC TAC TOE";
	}

	public GameBoard(int size){
		this(size, size);
	}

	public GameBoard(int row, int col){
		this(row, col, 3);
	}

	public GameBoard(int row, int col, int win){
		mouseClicked = false;
		xTurn = true;
		mX = mY = 0;
		mouseB = 0;

		WINLENGTH = win;

		board = new Grid(row,col);

		addMouseListener(this);
		setBackground(Color.WHITE);

		name = "CONNECT "+WINLENGTH;
	}

	public void mouseClicked(MouseEvent e)
	{
		mouseClicked = true;
		mX=e.getX();
		mY=e.getY();
		mouseB = e.getButton();
		repaint();
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.white);
		window.fillRect(0,0,640,480);
//		window.drawString("left mouse click == [X]", 420,85);
//		window.drawString("right mouse click == [O]", 420,105);

//		window.drawString(xTurn ? "X's turn" : "O's Turn", 420, 85);

		if(mouseClicked)
		{
			markBoard();
			board.drawGrid(window);

			if(determineWinner(window))
			{
			  board = new Grid(board.getNumRows(), board.getNumCols());
			}
			mouseClicked = false;
		}
		window.setColor(Color.BLUE);
		window.setFont(new Font("TAHOMA", Font.BOLD, 16));
		window.drawString(name, (SCALE * board.getNumCols()) + 75,55);
		window.drawString(xTurn ? "X's turn" : "O's Turn", (SCALE * board.getNumCols()) + 75, 85);

		//draw the board, Y
		for(int i = 0; i< board.getNumRows(); i++){
			//draw the board, X
			for(int j = 0; j< board.getNumCols(); j++){
				window.drawRect(j*SCALE+50, i*SCALE+50, SCALE, SCALE);
			}
		}
	}

	public Grid getBoard(){
		return board;
	}

	public void markBoard()
	{
		if(mX >=SCALE&& mX <=SCALE*(board.getNumCols() + 1)&& mY >=SCALE&& mY <=SCALE*(board.getNumRows() + 1))
		{
			//gets the index for the board
			int r = mY/SCALE-1, c = mX/SCALE-1;

			Piece piece = (Piece)board.getSpot(r,c);

			if(mouseB == MouseEvent.BUTTON1 && piece == null){
				if(xTurn){
					board.setSpot(r,c,new Piece(5+c*SCALE+50,5+r*SCALE+50,SCALE-10,SCALE-10,"X",Color.GREEN));
				}else{ //(mouseB == MouseEvent.BUTTON3){
					board.setSpot(r,c,new Piece(5+c*SCALE+50,5+r*SCALE+50,SCALE-10,SCALE-10,"O",Color.RED));
				}
				xTurn = !xTurn;
			}
			//if BUTTON3 was pressed and BUTTON3 was not pressed last mouse press
			//save the current button pressed to compare to next button pressed
//			prevMouseB=mouseB;
		}
	}
	
	public boolean determineWinner(Graphics window)
	{
		String winner = winHorizontal();

		if(winner == null){
			winner = winVertical();
			if(winner == null){
				winner = winDiagonal();
				if(winner == null){
					winner = "";
				}else{
					winner += " wins diagonally!";
				}
			}else{
				winner += " wins vertically!";
			}
		}else{
			winner += " wins horizontally!";
		}


		//if the board is full and there is no winner
		if(board.drawGrid(window)&&winner.length()==0){
		   winner =  "cat's game - no winner!\n";
		}
				
		if(winner.length()>0)
		{
			window.setFont(new Font("TAHOMA",Font.BOLD,22));
			window.setColor(Color.orange);
			window.drawString(winner, (SCALE * board.getNumCols()) + 65,255);
			try{
			   Thread.currentThread().sleep(2500);
			}
			catch(Exception e){
			}
			repaint();
			return true;
		}
		return false;
	}

	public String winHorizontal(){
		Piece[] row;

		outer:
		for(int i = 0; i<board.getNumRows(); i++){

			center:
			for(int j = 0; j+WINLENGTH-1<board.getNumCols(); j++){
				row = new Piece[WINLENGTH];

				//label lets you break to certain loops instead of just one at a time
				inner:
				for(int k = 0; k<row.length; k++){
					Piece bruh = (Piece) board.getSpot(i, j+k);
					if(bruh == null){
						break inner;
					}else{
						row[k] = bruh;
					}
				}

				if(winningPieces(row)){
					return row[0].getName();
				}
			}
		}

		return null;
	}

	public String winVertical(){
		Piece[] col;

		for(int i = 0; i<board.getNumCols(); i++){
			for(int j = 0; j+WINLENGTH-1<board.getNumRows(); j++){
				col = new Piece[WINLENGTH];

				for(int k = 0; k<col.length; k++){
					Piece bruh = (Piece) board.getSpot(j+k, i);
					if(bruh == null){
						break;
					}else{
						col[k] = bruh;
					}
				}

				if(winningPieces(col)){
					return col[0].getName();
				}
			}
		}

		return null;
	}

	public String winDiagonal(){
		Piece[] dia;

		for(int y = 0; y + WINLENGTH - 1 < board.getNumRows(); y++){

			for(int x = 0; x < board.getNumCols(); x++){

				dia = new Piece[WINLENGTH];

				if(x + WINLENGTH - 1 >= board.getNumCols() && x + 1 - WINLENGTH < 0){
					continue;
				}

				toRight:
				for(int k = 0; k<WINLENGTH && k + x < board.getNumCols() && k + y < board.getNumRows(); k++){
					Piece bruh = (Piece) board.getSpot(y + k, x + k);

					if(bruh == null){
						break;
					}else{
						dia[k] = bruh;
					}
				}

				if(winningPieces(dia)){
					return dia[0].getName();
				}else{
					dia = new Piece[WINLENGTH];
				}

				toLeft:
				for(int k = 0; k<WINLENGTH && x - k >= 0 && y + k < board.getNumRows(); k++){
					Piece bruh = (Piece) board.getSpot(y + k, x - k);

					if(bruh == null){
						break;
					}else{
						dia[k] = bruh;
					}
				}

				if(winningPieces(dia)){
					return dia[0].getName();
				}
			}
		}

		return null;
	}

	public boolean winningPieces(Piece[] p){
		Piece bruh = p[0];

		for(int k = 1; k<p.length; k++){
			try{
				if(!bruh.getName().equals( p[k].getName() ) ){
					return false;
				}
			}catch(NullPointerException e){
				return false;
			}
		}

		return true;
	}

	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}