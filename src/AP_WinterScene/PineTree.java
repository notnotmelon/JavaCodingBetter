package AP_WinterScene;

import java.awt.*;

public class PineTree extends AbstractShape{

    public PineTree(int x, int y, int w, int h, Color c){
        super(x, y, w, h, c, 0, 0);
    }

//    @Override
    public void draw(Graphics window) {
        window.setColor(Color.orange);

        int x = getXPos(), y = getYPos(), w = getWidth(), h = getHeight();

        window.fillRect(x + w/4, y, w/2, h/3);

        window.setColor(getColor());

        window.fillPolygon(new int[]{x, x + w / 2, x + w}, new int[]{y, y - h/2, y}, 3);
        window.fillPolygon(new int[]{x+w/5, x+w/2, x+ w/5 *4}, new int[]{(y - h/2) + h/10, (y - (h/5) * 4) + h/10,(y - h/2) + h/10}, 3);
        window.fillPolygon(new int[]{x + w/3, x + w/2, x + w/3 * 2}, new int[]{(y - (h/5) * 4) + h/7, (y - h) + h/7 , (y - (h/5) * 4) + h/7}, 3);
    }

    public void moveAndDraw(Graphics window){
        draw(window);
    }
}
