import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Yuan Gao
 * @see Shape
 */
public class Rect extends Shape{
	private int x; // x position of the first corner
	private int y; // y position of the first corner
	private int width = 50;
	private int height = 30;
	
	/**
	 * Create a Rectangle, setting its color. 
	 * 
	 * @param c the color you wish the Rectangle to initially have
	 */	
	public Rect(Color c) {
		super(c);
	}

	/**
	 * 
	 * @param page
	 */
	public void drawShape(Graphics page) {
		page.fillRect(x, y, width, height);
	}

	@Override
	public boolean containsPoint(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getCenter() {
		// TODO Auto-generated method stub
		return null;
	}
}
