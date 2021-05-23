package AP_TicTacToe;//(c) A+ Computer Science
//www.apluscompsci.com
//Name - 

import java.awt.Graphics;

public class Grid
{
	private Cell[][] grid;
	
	public Grid()
	{
		this(0,0);
	}

	public Grid(int rows, int cols)
	{
		setSize(rows, cols);
	}

	public void setSize(int rows, int cols)
	{
		grid = new Cell[rows][cols];
	}

	public void setSpot(int row,int col, Cell val)
	{
		grid[row][col] = val;
	}
	
	public Cell getSpot(int row, int col)
	{
		return grid[row][col];
	}
	
	public int getNumRows()
	{
		return grid.length;
	}
	
	public int getNumCols()
	{
		return grid[0].length;
	}

	public boolean drawGrid(Graphics window)
	{
		boolean full=true;

		for(Cell[] j : grid){
			for(Cell k : j){
				if(k == null){
					full = false;
				}else{
					k.draw(window);
				}
			}
		}

		return full;
	}
	
	public String toString()
	{
		String output="";
		for(Cell[] j : grid){
			output += "[";
			for(Cell k : j){
				output += k + "; ";
			}
			output = output.substring(0, output.length()-2)+"]\n";
		}
		return output;
	}
}