import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Yuan Gao
 * @see Shape
 */
public class Rect extends Shape{
	private int x; // x position of the top left corner
	private int y; // y position of the top left corner
	private int width;
	private int height;
	
	/**
	 * Create a Rectangle, setting its color. 
	 * 
	 * @param c the color you wish the Rectangle to initially have
	 */	
	public Rect(Color c) {
		super(c);
	}

	/**
	 * Draw the rectangle based on the position of first corner and size
	 * 
	 * @param page
	 */
	public void drawShape(Graphics page) {
		page.fillRect(x, y, width, height);
	}

	@Override
	public boolean containsPoint(Point p) {
	
		return false;
	}

	/**
	 * 
	 */
	public void move(int deltaX, int deltaY) {
		x = x + deltaX;
		y = y + deltaY;
	}

	/**
	 * Get the center of the rectangle
	 * 
	 * @return the position of the center of the rectangle
	 */
	public Point getCenter() {
		Point center = new Point();
		center.x = x + (width / 2);
		center.y = y + (height / 2);
		
		return center;
	}
	
	/**
	 * Get the position where the rectangle starts to be drew
	 * 
	 * @param p the position of the start point
	 */
	public void getStartPoint(Point p) {
		x = p.x;
		y = p.y;
	}
	
	/**
	 * Get the new position of mouse during drawing,
	 * update the form of the rectangle 
	 * 
	 * @param p the position of the end point
	 */
	public void updatePos(Point p) {
		width = p.x - x;
		height = p.y - y;
	}


}
