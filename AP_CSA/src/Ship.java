//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.Console;
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;

	public Ship()
	{
		this(10,10);
	}

	public Ship(int x, int y)
	{
	   this(x,y,10);
	}

	public Ship(int x, int y, int s)
	{
	   this(x,y,10,10,10);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("ship.png");
			setImage(ImageIO.read(url) );
		}
		catch(Exception e)
		{
			System.out.println("bruh");
			try{
				URL url = getClass().getResource("AP_StarFighter/ship.png");
				setImage(ImageIO.read(url) );
			}catch(Exception f){

			}
		}
	}

	public void setImage(Image i){
		image = i;
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(int dir)
	{
		switch(dir){
			case(Directions.LEFT):
				horMove(false);
				break;
			case(Directions.RIGHT):
				horMove(true);
				break;
			case(Directions.UP):
				vertMove(false);
				break;
			case(Directions.DOWN):
				vertMove(true);
				break;
			case(Directions.LEFT + Directions.UP):
				horMove(false);
				vertMove(false);
				break;
			case(Directions.RIGHT + Directions.DOWN):
				horMove(true);
				vertMove(true);
				break;
			case(Directions.UP + Directions.RIGHT):
				horMove(true);
				vertMove(false);
				break;
			case(Directions.DOWN + Directions.LEFT):
				horMove(false);
				vertMove(true);
				break;
			default:
				break;
		}
	}

	public void vertMove(boolean pos){
		setY( pos ? getY() + getSpeed() : getY() - getSpeed());
	}

	public void horMove(boolean pos){
		setX( pos ? getX() + getSpeed() : getX() - getSpeed());
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
