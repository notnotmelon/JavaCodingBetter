//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public interface Moveable
{
    public void setPos( int x, int y);
    public void setX( int x );
    public void setY( int y );

    public int getX();
    public int getY();

	 public int getWidth();
	 int getHeight();
	 void setWidth( int w );
	 void setHeight( int h );

    public void setSpeed( int s );
	 public int getSpeed();
}
