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

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();

		while(size --> 0){
			add(new Alien((size*50) % 750 + 20, ((size*50) / 750) * 50 + 20 , 50, 50, 1));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for(Alien j : aliens){
			j.draw(window);
		}
	}

	public void moveEmAll()
	{
		for(Alien j : aliens){
			j.move();
			j.setDirection(0, 800);
		}
	}

	//phone: 8325160004

	public void removeDeadOnes(List<Ammo> shots)
	{
		for(int i = 0; i<aliens.size(); i++){
			for(Ammo j : shots){
				if(j.getX() > aliens.get(i).getX() && j.getX() < aliens.get(i).getX() + aliens.get(i).getWidth() &&
						j.getY() > aliens.get(i).getY() && j.getY() < aliens.get(i).getY() + aliens.get(i).getHeight()){
					j.setPos(-20, -20);
					aliens.remove(i);
					if(aliens.size() == 0){
						return;
					}
					i = i <= 0 ? 0 : i - 1;
				}
			}
		}
	}

	//hash position? x = n, y = n * end of x

	public String toString()
	{
		return "";
	}
}
