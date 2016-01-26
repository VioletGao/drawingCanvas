import java.awt.*;

/**
 * Ellipse.java
 * Class for an ellipse.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen 
 * @see Shape
 */
public class Ellipse extends Shape {
	private int left;
	private int top;
	private int width;
	private int height;
	
	/**
	 * Create an Ellipse, setting its color. 
	 * 
	 * @param c the color you wish the Ellipse to initially have
	 */
	public Ellipse(Color c) {
		super(c);
	}
	
	
	@Override
	public void drawShape(Graphics page) {
		page.drawOval(left, top, width, height);
	}

	/**
	 * check if a Point is in the Ellipse
	 * @param p the given Point
	 * @return true if the Ellipse contains the Point, 
	 * or false if it does not contain the Point
	 */
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
