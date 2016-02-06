import java.awt.*;

/**
 * Rect.java
 * Class for a rectangle.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Shape
 */
public class Rect extends Shape{	
	//private int x; // x coordinate where mouse first press
	//private int y; // y coordinate where mouse first press
	
	private int left; // x position of the top left corner
	private int top; // y position of the top left corner
	private int width; // width of the rectangle
	private int height; // height of the rectangle
	private int tolerance = 10;
	
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
	 * Set the x value of the upper left corner of Rect
	 * @param x new x value
	 */
	public void setX(int x) {
		left = x;
	}

	/**
	 * Set the y value of the upper left corner of Rect
	 * @param y new y value
	 */
	public void setY(int y) {
		top = y;
	}

	/**
	 * @return x value of the upper left corner of Rect
	 */
	public int getX() {
		return left;
	}

	/**
	 * @return the y value of the upper left corner of Rect
	 */
	public int getY() {
		return top;
	}

	/**
	 * Set the width of the Rect to width
	 * @param width the new width
	 */
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	/**
	 * Set the height of the Rect to height
	 * @param height the new height
	 */
	public void setHeight(int newheight) {
		height = newheight;
	}

	
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

	
/*	*//**
	 * Get the position where the rectangle starts to be drew
	 * 
	 * @param p the position of the start point
	 *//*
	public void getStartPoint(Point p) {
		x = p.x;
		y = p.y;
		left = p.x;
		top = p.y;
	}
	
	*//**
	 * Get the new position of mouse during drawing, update the form of the rectangle 
	 * 
	 * @param p the position of the end point
	 *//*
	public void updatePos(Point p) {
		width = Math.abs(p.x - x);
		height = Math.abs(p.y - y);
		
		if (p.x < x) {
			left = p.x;
		}
		if (p.y < y) {
			top = p.y;
		}
	}*/

	private boolean closetoTopLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance 
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	private boolean closetoTopRight(Point p) {
		return (p.x >= left + width - tolerance && p.x <= left + width + tolerance
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	private boolean closetoBottomLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance 
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
	
	private boolean closetoBottomRight(Point p) {
		return (p.x >= left + width - tolerance && p.x <= left + width + tolerance
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
}
