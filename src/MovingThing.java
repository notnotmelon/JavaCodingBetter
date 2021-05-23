//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Moveable
{
	private int xPos;
	private int yPos;
	private int wid;
	private int hgt;

	public MovingThing()
	{
		this(10,10);
	}

	public MovingThing(int x, int y)
	{
		this(x, y, 10, 10);
	}

	public MovingThing(int x, int y, int w, int h)
	{
		xPos = x; yPos = y;
		wid = w; hgt = h;
	}

	public void setPos( int x, int y)
	{
		setX(x);
		setY(y);
	}

	public void setX(int x)
	{
		xPos = x;
	}

	public void setY(int y)
	{
		yPos = y;
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public void setWidth(int w)
	{
		wid = w;
	}

	public void setHeight(int h)
	{
		hgt = h;
	}

	public int getWidth()
	{
		return wid;
	}

	public int getHeight()
	{
		return hgt;
	}

	public abstract void move(int direction);
	public abstract void draw(Graphics window);

	public String toString()
	{
		return "(" + getX() + ", " + getY() + ") " + getWidth() + ", " + getHeight();
	}
}