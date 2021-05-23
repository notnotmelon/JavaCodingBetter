package AP_WinterScene;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class WinterScenePanel extends JPanel implements Runnable
{
	private List<AbstractShape> sF;
	private AbstractShape sMan, pT;

	public WinterScenePanel()
	{
		setVisible(true);
		//refer shapes to a new ArrayList of AbstractShape

		sF = new ArrayList<AbstractShape>();
		//populate the list with 50 unique snowflakes

		Random dude = new Random();

		for(int i = 0; i<50; i++){
			sF.add(new SimpleSnowFlake(dude.nextInt(599)+1, 0, dude.nextInt(100) + 1,
					dude.nextInt(100) + 1, dude.nextInt(41) - 20, dude.nextInt(20)+1));
		}

		sMan = new SnowMan(620, 430, 130, 100);

		pT = new PineTree(150, 400, 120, 300, Color.green);

		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.WHITE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("MAKE A WINTER SCENE!",40,40);

		//make the snowman appear
		sMan.draw(window);
		pT.draw(window);
		//make the snowflakes appear and move down the screen
		for(AbstractShape j : sF){
			if(j.getXPos() < 0){
				j.setXSpeed(Math.abs(j.getXSpeed()));
			}else if(j.getXPos() > getWidth()){
				j.setXSpeed(-Math.abs(j.getXSpeed()));
			}
			if(j.getYPos() > getHeight()){
				j.setYPos(0);
			}
			j.moveAndDraw(window);
		}
		//check to see if any of the snowflakes need to be reset to the top of the screen
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(35);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}