import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 *
 * @author Yuan Gao
 * @see Shape
 */
public class Rect extends Shape{
	
	private int x; // x coordinate where mouse first press
	private int y; // y coordinate where mouse first press
	
	private int left; // x position of the top left corner
	private int top; // y position of the top left corner
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
	 * @param page the page you wish to draw the shape on
	 */
	public void drawShape(Graphics page) {
		page.fillRect(left, top, width, height);
	}

	/**
	 * Check if a point is located within the tolerance of the line
	 * @param p the position given to be checked
	 */
	public boolean containsPoint(Point p) {
		
		return (p.x >= left && p.x <= left + width && p.y >= top && p.y <= top + height);	
	}

	/**
	 * Move the rectangle 
	 * 
	 * @param deltaX the change in x coordinates
	 * @param deltaY the change in y coordinates
	 */
	public void move(int deltaX, int deltaY) {
		left = left + deltaX;
		top = top + deltaY;
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
		left = p.x;
		top = p.y;
	}
	
	/**
	 * Get the new position of mouse during drawing,
	 * update the form of the rectangle 
	 * 
	 * @param p the position of the end point
	 */
	public void updatePos(Point p) {
		width = Math.abs(p.x - x);
		height = Math.abs(p.y - y);
		
		if (p.x < x) {
			left = p.x;
		}
		if (p.y < y) {
			top = p.y;
		}
	}


}
