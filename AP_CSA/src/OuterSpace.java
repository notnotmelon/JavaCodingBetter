//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
//	private Alien alienOne;
//	private Alien alienTwo;

	/* uncomment once you are ready for this part
	 * */
   private AlienHorde horde;
	private Bullets shots;

	//direction using added values from directions class
	private int dir;
	private boolean[] keys;

	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien

		ship = new Ship(100,100,50,50,2);
//		alienOne = new Alien(25, 5, 50, 50, 1);
//		alienTwo = new Alien(125, 5, 50, 50, 1);

		horde = new AlienHorde(20);

		shots = new Bullets();

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back==null) {
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,getWidth(),getHeight());

		ship.move(dir);
		if(ship.getX() < 0 || ship.getX() + ship.getWidth() > getWidth()){
			ship.setX( ship.getX() < 0 ? 0 : getWidth() - ship.getWidth());
		}
		if(ship.getY() < 0 || ship.getY() + ship.getHeight() > getHeight()){
			ship.setY( ship.getY() < 0 ? 0 : getHeight() - ship.getHeight());
		}

		if(keys[4] == true){
//			System.out.println("firer");
			shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - 5, ship.getY(), 3, true));
			keys[4] = false;
		}
		shots.moveEmAll();

		horde.moveEmAll();
		horde.removeDeadOnes(shots.getList());

		shots.cleanEmUp(getHeight());

//		alienOne.autoMove();
//		alienOne.setDirection(0, 300);
//		alienTwo.autoMove();
//		alienTwo.setDirection(125, 425);

		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

//		alienOne.draw(graphToBack);
//		alienTwo.draw(graphToBack);
		ship.draw(graphToBack);
		shots.drawEmAll(graphToBack);
		horde.drawEmAll(graphToBack);

		twoDGraph.drawImage(back, null, 0, 0);
		back = null;
	}


	public void keyPressed(KeyEvent e)
	{
		//try using switch cases and enumerators later
		if (!keys[0] && e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			dir += Directions.LEFT;
			keys[0] = true;
		}
		if (!keys[1] && e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			dir += Directions.RIGHT;
			keys[1] = true;
		}
		if (!keys[2] && e.getKeyCode() == KeyEvent.VK_UP)
		{
			dir += Directions.UP;
			keys[2] = true;
		}
		if (!keys[3] && e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			dir += Directions.DOWN;
			keys[3] = true;
		}
		if (!keys[4] && e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (keys[0] && e.getKeyCode() == KeyEvent.VK_LEFT)
		{
//			System.out.println("left release");
			dir -= Directions.LEFT;
			keys[0] = false;
		}
		if (keys[1] && e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
//			System.out.println("right release");
			dir -= Directions.RIGHT;
			keys[1] = false;
		}
		if (keys[2] && e.getKeyCode() == KeyEvent.VK_UP)
		{
//			System.out.println("up release");
			dir -= Directions.UP;
			keys[2] = false;
		}
		if (keys[3] && e.getKeyCode() == KeyEvent.VK_DOWN)
		{
//			System.out.println("down release");
			dir -= Directions.DOWN;
			keys[3] = false;
		}
		if (keys[4] && e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e){//no code needed here
		}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
//   		   System.out.println(dir);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

