import java.awt.*;

/**
 * Segment.java
 * Class for a line segment.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 * Modified by YG for CSC260 Project1.
 * @author Thomas H. Cormen; Yuan Gao
 * @see Shape
 */
public class Segment extends Shape {

  private int x1; // x coordinate of the first endpoint
  private int y1; // y coordinate of the first endpoint
  private int x2; // x coordinate of the second endpoint
  private int y2; // y coordinate of the second endpoint
  
  private int left; // most left coordinate of the segment
  private int top; // most top coordinate of the segment
  private int right; // most right coordinate of the segment
  private int bottom; // most bottom coordinate of the segment
  
  private double tolerance = 3; // tolerance for clicking the line
  private int distance = 4; // if the distance of the point is closer than this value,
                            // the point is counted within the line
  
  /**
   * Create a line, setting its color
   * 
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
  	
  	left = Math.min(x1, x2);
  	right = Math.max(x1, x2);

  	top = Math.min(y1, y2);
  	bottom = Math.max(y1, y2);
	
  	return (almostContainsPoint(p, left, top, right, bottom, tolerance) && distanceToPoint(p, x1, y1, x2, y2) <= distance);
  }

/**
 * Move the line according to the change of coordinates
 * 
 * @param deltaX the change in x coordinates
 * @param deltaY the change in y coordinates
 */
  public void move(int deltaX, int deltaY) {
  	x1 += deltaX; y1 += deltaY;
  	x2 += deltaX; y2 += deltaY;
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
   * Get the x coordinate of the first endpoint
   * 
   * @return x coordinate of the first endpoint
   */
  public int getX1() {
	  return x1;
  }
  
  /**
   * Get the x coordinate of the second endpoint
   * 
   * @return x coordinate of the second endpoint
   */
  public int getX2() {
	  return x2;
  }
  
  /**
   * Get the y coordinate of the first endpoint
   * 
   * @return y coordinate of the first endpoint
   */
  public int getY1() {
	  return y1;
  }
  
  /**
   * Get the y coordinate of the second endpoint
   * 
   * @return y coordinate of the second endpoint
   */
  public int getY2() {
	  return y2;
  }
  
  /**
   * Set the x coordinate of the first endpoint
   * 
   * @param newX1 new x coordinate
   */
  public void setX1(int newX1) {
	  x1 = newX1;
  }
  
  /**
   * Set the x coordinate of the second endpoint
   * 
   * @param newX2 new x coordinate
   */
  public void setX2(int newX2) {
	  x2 = newX2;
  }
  
  /**
   * Set the y coordinate of the first endpoint
   * 
   * @param newY1 new y coordinate
   */
  public void setY1(int newY1) {
	  y1 = newY1;
  }
  
  /**
   * Set the y coordinate of the second endpoint
   * 
   * @param newY2 new y coordinate
   */
  public void setY2(int newY2) {
	  y2 = newY2;
  }
  
  /**
   * Reshape the line if the mouse dragged near the endpoints
   * 
   * @param p location where the mouse pressed
   */
  public void reshape(Point p) {
	  if (closetoEndpoint1(p)) {
		  x1 = p.x;
		  y1 = p.y;
	  } else if (closetoEndpoint2(p)) {
		  x2 = p.x;
		  y2 = p.y;
	  }
  }
  
  // Helper methods that check if the mouse is pressed near the first endpoint
  private boolean closetoEndpoint1 (Point p) {
	  return (p.x <= x1 + tolerance && p.x >= x1 - tolerance && p.y <= y1 + tolerance && p.y >= y1 - tolerance);
  }

  // Helper methods that check if the mouse is pressed near the second endpoint
  private boolean closetoEndpoint2 (Point p) {
	  return (p.x <= x2 + tolerance && p.x >= x2 - tolerance && p.y <= y2 + tolerance && p.y >= y2 - tolerance);
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
