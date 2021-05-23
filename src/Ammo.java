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
	private boolean player;

	public Ammo()
	{
		this(0,0);
	}

	public Ammo(int x, int y)
	{
		this(x, y, 0, true);
	}

	public Ammo(int x, int y, int s, boolean p)
	{
		super(x, y, 10, 10);
		setSpeed(s);
		player = p;
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return 0;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void move(int direction )
	{
		setY(direction < 2 ? getY() - speed : getY() + speed);
	}

	public String toString()
	{
		return super.toString();
	}
}
