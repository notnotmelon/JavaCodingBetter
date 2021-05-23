package AP_TicTacToe;//(c) A+ Computer Science
//www.apluscompsci.com
//Name - 

import java.awt.Graphics;

public abstract class Cell implements Locatable
{
	//x y position, width, height
	private int x, y, wid, hgt;

	public Cell()
	{
		this(5,5);
	}

	public Cell(int x, int y)
	{
		this(x, y, 5, 5);
	}

	public Cell(int x, int y, int w, int h)
	{
		setPos(x, y);
		setWidth(w);
		setHeight(h);
	}

	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public void setX( int x )
	{
		this.x = x;
	}
	
	public void setY( int y )
	{
		this.y = y;
	}

	public void setWidth(int w)
	{
		wid = w;
	}
	
	public void setHeight(int h)
	{
		hgt = h;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}	

	public int getWidth()
	{
		return wid;
	}	
	
	public int getHeight()
	{
		return hgt;
	}
	
	public abstract void draw(Graphics window);
	
	public String toString()
	{
		return getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight();
	}
}