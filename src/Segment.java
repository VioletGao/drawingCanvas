import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 *
 * @author Thomas H. Cormen
 * @see Shape
 */
public class Segment extends Shape {

  private int x1; // x position of the start point
  private int y1; // y position of the start point
  private int x2; // x position of the end point
  private int y2; // y position of the end point
  
  private int left; 
  private int top;
  private int right;
  private int bottom;
  
  private double tolerance = 3; // tolerance for clicking the line
  private int distance = 5;
  /**
   * Create a line, setting its color
   * @param c the color you wish the shape to initially have
   */
  public Segment(Color c) {
		super(c);
	}
  
  /**
   * Draw the line
   * 
   * @param page the page you wish to draw the shape on
   */
  public void drawShape(Graphics page) {
  	page.drawLine(x1, y1, x2, y2);
  	
  }

/**
 * Check if a point is located within the tolerance of the line
 * 
 * @param p the position given to be checked
 */
  public boolean containsPoint(Point p) {
  	if (x1 < x2) {
  		left = x1; right = x2;
  	} else { 
  		left = x2; right = x1;
  	}
  	
  	if (y1 < y2) {
  		top = y1; bottom = y2;
  	} else {
  		top = y2; bottom = y2;
  	}
	
  	return (almostContainsPoint(p, left, top, right, bottom, tolerance) && distanceToPoint(p, x1, y1, x2, y2) <= distance);
  }

/**
 * 
 * @param deltaX
 * @param deltaY
 */
  public void move(int deltaX, int deltaY) {
  	x1 = x1 + deltaX; y1 = y1 + deltaY;
  	x2 = x2 + deltaX; y2 = y2 + deltaY;
  }

  /**
   * Get the center of the line
   * 
   * @return the location of the center of the line
   */
  public Point getCenter() {
  	Point center = new Point();
  	
  	int centerX = (x1 + x2) / 2;
  	int centerY = (y1 + y2) / 2;
  	center.setLocation(centerX, centerY);
  	
  	return center;
  }
  
  /**
   * Get the position where the rectangle starts to be drew
   * 
   * @param p the position of the start point
   */
  public void getStartPoint(Point p) {
	 x1 = p.x;
	 y1 = p.y;
	 x2 = p.x;
	 y2 = p.y;
  }
  
  /**
   * Get the new position of mouse during drawing
   * update the drawing of the line
   * 
   * @param p the position of the end point
   */
  public void updatePos(Point p) {
	x2 = p.x;
	y2 = p.y;
  }
  
// Helper method that returns true if Point p is within a tolerance of a
  // given bounding box. Here, the bounding box is given by the coordinates of
  // its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.
      // Compute m, the slope of the line containing the segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and that
      // contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }


}
