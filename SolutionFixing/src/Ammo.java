//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0,0,0);
	}

	public Ammo(int x, int y)
	{
		this(x,y,10,10,0);
	}

	public Ammo(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
	}

	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
      if(direction.equals("UP"))
	      setY(getY()-getSpeed());
      else if(direction.equals("DOWN"))
	      setY(getY()+getSpeed());
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
   	window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
