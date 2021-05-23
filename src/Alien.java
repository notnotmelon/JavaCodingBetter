//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends Ship
{
	private boolean goLeft;

	public Alien()
	{
		this(0,0);
	}

	public Alien(int x, int y)
	{
		this(x, y, 0);
	}

	public Alien(int x, int y, int s)
	{
		this(x,y, 50, 50, s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h, s);

		goLeft = false;

		try
		{
			URL url = getClass().getResource("alien.png");
			setImage(ImageIO.read(url) );
		}
		catch(Exception e)
		{
			System.out.println("bruh");
			try{
				URL url = getClass().getResource("AP_StarFighter/alien.png");
				setImage(ImageIO.read(url) );
			}catch(Exception f){

			}
		}
	}

	public void setDirection(int xMin, int xMax){
		if(getX() < xMin || getX() + getWidth() > xMax){
			goLeft = getX() < xMin ? false : true;
			setY( getY() + getSpeed()*10);
		}
	}

	public void move(){
		move( goLeft ? Directions.LEFT : Directions.RIGHT);
	}

//   public void move(String direction)
//	{
//		switch(direction){
//			case("LEFT"):
//				setX(getX()-getSpeed());
//				break;
//			case("RIGHT"):
//				setX(getX()+getSpeed());
//				break;
//			case("UP"):
//				setY(getY()-getSpeed());
//				break;
//			case("DOWN"):
//				setY(getY()+getSpeed());
//				break;
//			default:
//				break;
//		}
//	}
}
