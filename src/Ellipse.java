import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 * Modified by YG for CSC260 Project1
 * @author Thomas H. Cormen; Yuan (Violet) Gao
 * @see Shape
 */
public class Ellipse extends Shape {

	private int left; // x position of the top left corner
	private int top; // y position of the top left corner
	private int width; // width of the ellipse
	private int height; // height of the ellipse
	private int tolerance = 10; // tolerance when click near to a corner
	
	/**
	 * Create an Ellipse, setting its color. 
	 * 
	 * @param c the color you wish the Ellipse to initially have
	 */
	public Ellipse(Color c) {
		super(c);
	}
	
	
	/**
	 * Draw the ellipse based on the position of the top left corner and size
	 * 
	 * @param page the page you wish to draw the shape on
	 */
	public void drawShape(Graphics page) {
		page.fillOval(left, top, width, height);
	}

	/**
	 * Check if a Point is in the Ellipse
	 * 
	 * @param p the given Point
	 * @return true if the Ellipse contains the Point, 
	 * false if it does not contain the Point
	 */
	public boolean containsPoint(Point p) {
		
		return pointInEllipse(p, left, top, width, height);
	}


	/**
	 * Move the ellipse based on the change in coordinates
	 * 
	 * @param deltaX the change in x coordinates
	 * @param deltaY the change in y coordinates
	 */
	public void move(int deltaX, int deltaY) {
		left = left + deltaX;
		top = top + deltaY;
	}


	/**
	 * Get the center of the ellipse
	 * 
	 * @return the position of the center of the ellipse
	 */
	public Point getCenter() {
		Point center = new Point();
		int centerX = left + width / 2;
		int centerY = top + height / 2;
		center.setLocation(centerX, centerY);
		
		return center;
	}

	/**
	 * Set the x value of the upper left corner of Ellipse
	 * @param x  new x coordinate of upper left corner
	 */
	public void setX(int x) {
		left = x;
	}

	/**
	 * Set the y value of the upper left corner of Ellipse
	 * @param y new y coordinate of upper left corner
	 */
	public void setY(int y) {
		top = y;
	}

	/**
	 * @return x coordinate of the upper left corner of Ellipse
	 */
	public int getX() {
		return left;
	}

	/**
	 * @return the y coordinate of the upper left corner of Ellipse
	 */
	public int getY() {
		return top;
	}

	/**
	 * Set the width of the Ellipse to width
	 * @param newwidth the new width
	 */
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	/**
	 * Set the height of the Ellipse to height
	 * @param newheight the new height
	 */
	public void setHeight(int newheight) {
		height = newheight;
	}

	/**
	 * Get the width of the Ellipse
	 * 
	 * @return width of the Ellipse
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Get the height of the Ellipse
	 * 
	 * @return height of the Ellipse
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Change the shape of the Ellipse
	 * 
	 * @param p the pressed location of the mouse
	 */
	public void reshape(Point p) {
		if (closetoTop(p)) {
			height += top - p.y;
			top = p.y;
		} else if (closetoBottom(p)) {
			height = p.y - top;
		} else if (closetoLeft(p)) {
			width += left - p.x;
			left = p.x;
		} else if (closetoRight(p)) {
			width = p.x - left;
		}
		
	}
	
	// Helper method that checks if the pressed location is close to the top corner of the Ellipse
	private boolean closetoTop(Point p) {
		return (p.x >= left + width/2 - tolerance && p.x <= left + width/2 + tolerance
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the bottom corner of the Ellipse
	private boolean closetoBottom(Point p) {
		return (p.x >= left + width/2 - tolerance && p.x <= left + width/2 + tolerance
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the left corner of the Ellipse
	private boolean closetoLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance
				&& p.y >= top + height/2 - tolerance && p.y <= top + height/2 + tolerance);
	}
	
	// Helper method that checks if the pressed location is close to the right corner of the Ellipse
	private boolean closetoRight(Point p) {
		return (p.x >= left + width - tolerance && p.x <= left + width + tolerance
				&& p.y >= top + height/2 - tolerance && p.y <= top + height/2 + tolerance);
	}
	
  // Helper method that returns whether Point p is in an Ellipse with the given
  // top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.
    // (See CRC, 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }

}
