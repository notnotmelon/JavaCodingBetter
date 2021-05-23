package AP_WinterScene;//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class SimpleSnowFlake extends AbstractShape{

    public SimpleSnowFlake(int x, int y, int w, int h, int xs, int ys){
        super(x,y,w,h,Color.white, xs, ys);
    }

    public void draw(Graphics window){
        window.setColor(getColor());

        int x = getXPos(), y = getYPos(), w = getWidth(), h = getHeight();

        window.drawLine(x - w/2, y, x, y - h/2);
//        window.drawLine(x - w/4, y - h/4, x, y - h/2);
        window.drawLine(x, y - h/2, x + w/2, y);
//        window.drawLine(x + w/4, y - h/4, x + w/2, y);

        window.drawLine(x + w/2, y, x, y + h/2);
//        window.drawLine(x + w/4, y + h/4, x, y + h/2);
        window.drawLine(x, y + h/2, x - w/2, y);
//        window.drawLine(x - w/4, y + h/4, x - w/2, y);
    }

    public void moveAndDraw(Graphics window){
        setXPos(getXPos() + getXSpeed());
        setYPos(getYPos() + getYSpeed());

        draw(window);
    }
}


