//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>();
	}

	public void add(Ammo a)
	{
		ammo.add(a);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for(Ammo j : ammo){
			j.draw(window);
		}
	}

	public void moveEmAll()
	{
		for(Ammo j : ammo){
			j.move(Directions.UP);
		}
	}

	public void cleanEmUp(int yMax)
	{
		for(int i = 0; i< ammo.size(); i++){
			if(ammo.get(i).getY() + ammo.get(i).getHeight() < 0 || ammo.get(i).getY() > yMax){
				ammo.remove(i);
				i--;
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return ammo.toString();
	}
}
