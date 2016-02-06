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
	
	private int x; // x coordinate where mouse first press
	private int y; // y coordinate where mouse first press
	
	private int left; // x position of the top left corner
	private int top; // y position of the top left corner
	private int width; // width of the ellipse
	private int height; // height of the ellipse
	private int tolerance = 10;
	
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
	 * Get the position where the ellipse starts to be drew
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
	 * Get the new position of mouse during drawing, update the form of the ellipse 
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
	
	private boolean closetoTop(Point p) {
		return (p.x >= left + width/2 - tolerance && p.x <= left + width/2 + tolerance
				&& p.y >= top - tolerance && p.y <= top + tolerance);
	}
	
	private boolean closetoBottom(Point p) {
		return (p.x >= left + width/2 - tolerance && p.x <= left + width/2 + tolerance
				&& p.y >= top + height - tolerance && p.y <= top + height + tolerance);
	}
	
	private boolean closetoLeft(Point p) {
		return (p.x >= left - tolerance && p.x <= left + tolerance
				&& p.y >= top + height/2 - tolerance && p.y <= top + height/2 + tolerance);
	}
	
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
