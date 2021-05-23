package AP_WinterScene;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
      window.setColor(getColor());

      int x = getXPos(), y = getYPos(), w = getWidth(), h = getHeight();
      window.fillOval(x, y, w, h);

      //if calculation is first, then equal to number of cases, else is plus one
      int bruh = 1;
      do {
         w = w / 3 * 2;
         x = x + w / 3 - w / 11;
         h = h / 3 * 2;
         y -= h - h / 18;

         window.fillOval(x, y, w, h);
      }while(bruh --> 0);

      window.setColor(Color.black);

      x+=w/2;
      y+=h/2;

      window.fillOval(x - 5, y - 2, 3, 3);
      window.fillOval(x + 5, y - 2, 3, 3);
      window.drawArc(x - 4, y + 1, 10, 8, 180, 180);
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}