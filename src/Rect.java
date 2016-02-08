import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Shape
 */
public class Rect extends Shape {	

	private int left; // x position of the top left corner
	private int top; // y position of the top left corner
	private int width; // width of the rectangle
	private int height; // height of the rectangle
	private int tolerance = 10; // tolerance when pressed near to a corner of the rect
	
	/**
	 * Create a Rectangle, setting its color. 
	 * 
	 * @param c the color you wish the Rectangle to initially have
	 */	
	public Rect(Color c) {
		super(c);
	}
	
	/**
	 * Draw the rectangle based on the position of the top left corner and size
	 * 
	 * @param page the page you wish to draw the shape on
	 */
	public void drawShape(Graphics page) {
		page.fillRect(left, top, width, height);
	}

	/**
	 * Check if a point is located within the rectangle
	 * 
	 * @param p the position given to be checked
	 */
	public boolean containsPoint(Point p) {
		
		return (p.x >= left && p.x <= left + width && p.y >= top && p.y <= top + height);	
	}

	/**
	 * Move the rectangle based on the change of the coordinates
	 * 
	 * @param deltaX the change in x coordinates
	 * @param deltaY the change in y coordinates
	 */
	public void move(int deltaX, int deltaY) {
		left += deltaX;
		top += deltaY;
	}

	/**
	 * Get the center of the rectangle
	 * 
	 * @return the position of the center of the rectangle
	 */
	public Point getCenter() {
		Point center = new Point();
		center.x = left + (width / 2);
		center.y = top + (height / 2);
		
		return center;
	}
	
	/**
	 * Set the x coordinate of the upper left corner of Rect
	 * 
	 * @param x new x coordinate of upper left corner
	 */
	public void setX(int x) {
		left = x;
	}

	/**
	 * Set the y coordinate of the upper left corner of Rect
	 * 
	 * @param y new y coordinate of upper left corner
	 */
	public void setY(int y) {
		top = y;
	}

	/**
	 * Get the x coordinate of the upper left corner
	 * 
	 * @return x coordinate of the upper left corner of Rect
	 */
	public int getX() {
		return left;
	}

	/**
	 * Get the y coordinate of the upper left corner
	 * 
	 * @return the y coordinate of the upper left corner of Rect
	 */
	public int getY() {
		return top;
	}

	/**
	 * Set the width of the Rect to width
	 * 
	 * @param newWidth the new width
	 */
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	/**
	 * Set the height of the Rect to height
	 * 
	 * @param newHeight the new height
	 */
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	/**
	 * Get the width of the Rectangle
	 * 
	 * @return width of the Rectangle
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Get the height of the Rectangle
	 * 
	 * @return height of the Rectangle
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Change the shape of the Rectangle
	 * 
	 * @param p the pressed location of the mouse
	 */
	public void reshape(Point p) {
		if (closetoTopLeft(p)) {
			width += left - p.x;
			height += top - p.y;
			left = p.x;
			top = p.y;
		} else if (closetoTopRight(p)) {
			width = p.x - left;
			height += top - p.y;
			top = p.y;
		} else if (closetoBottomLeft(p)) {
			width += left - p.x;
			height = p.y - top;
			left = p.x;
		} else if (closetoBottomRight(p)) {
			width = p.x - left;
			height = p.y - top;
		}
		
	}

	// Helper method that checks if the pressed location is close to the top left corner of the Rectangle
	private boolean closetoTopLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance 
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the top right corner of the Rectangle
	private boolean closetoTopRight(Point p) {
		return (p.x >= left + width - tolerance && p.x <= left + width + tolerance
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the bottom left corner of the Rectangle
	private boolean closetoBottomLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance 
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the bottom right corner of the Rectangle
	private boolean closetoBottomRight(Point p) {
		return (p.x >= left + width - tolerance && p.x <= left + width + tolerance
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
}
