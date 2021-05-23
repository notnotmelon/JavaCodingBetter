package AP_WinterScene;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public abstract class AbstractShape
{
   //positions, dimensions, speeds
	private int x, y, w, h, xS, yS;

	private Color color;

   public AbstractShape(int x, int y, int wid, int ht)
   {
		this.x = x;
		this.y = y;
		w = wid;
		h = ht;
		color = Color.WHITE;
		xS = 0;
		yS= 0;
   }
   
   public AbstractShape(int x, int y, int wid, int ht, Color col)
   {
		this.x = x;
		this.y = y;
		w = wid;
		h = ht;
		color = col;
		xS = 0;
		yS= 0;
   }   
   
   public AbstractShape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		this.x = x;
		this.y = y;
		w = wid;
		h = ht;
		color = col;
		xS = xSpd;
		yS= ySpd;
   }  
  
   //add in set and get methods for pos and speed
   public void setXPos( int xp)
   {
   	x = xp;
   }
   
   public void setYPos( int yp)
   {
   	y = yp;
   }
   
   public void setXSpeed( int xs)
   {
   	xS = xs;
   }
   
   public void setYSpeed(int ys)
   {
   	yS = ys;
   }
   
   public int getYSpeed()
   {
   	return yS;
   }
   
   public int getXSpeed()
   {
   	return xS;
   }
   
   public int getXPos()
   {
   	return x;
   }
   
   public int getYPos()
   {
   	return y;
   }
   
   public Color getColor()
   {
   	return color;
   }
   
   public int getWidth()
   {
   	return w;
   }
   
   public int getHeight()
   {
   	return h;
   }

   public abstract void draw(Graphics window);

   public abstract void moveAndDraw(Graphics window);

   public String toString()
   {
   	return x+" "+y+" "+w+" "+h+" "+color+" "+xS+" "+yS;
   }
}