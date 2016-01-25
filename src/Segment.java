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
  // YOU FILL IN INSTANCE VARIABLES AND METHODS.
  private int x1; // x position of the start point
  private int y1; // y position of the start point
  private int x2; // x position of the end point
  private int y2; // y position of the end point

  /**
   * Create a line, setting its color
   * @param c the color you wish the shape to initially have
   */
  public Segment(Color c) {
		super(c);
	}
  
  /**
   * Draw the line
   * @param page the page you wish to draw the shape on
   */
  public void drawShape(Graphics page) {
  	page.drawLine(x1, y1, x2, y2);
  	
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
