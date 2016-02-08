import java.awt.*;

/**
 * ExchangeCmd.java
 * Command class to perform an exchange command.
 * 
 * Written by THC for CS 5 Lab Assignment 3.
 * @author Thomas H. Cormen
 * @see Command
 */
public class ExchangeCmd extends UndoableCommand {
  private Shape firstShape; // the first Shape clicked
  private Shape s; // one of the manipulated shape
  private Shape s1; // the other manipulated shape
  private Point firstCenter;
  private Point secondCenter;
  
  /**
   * When the mouse is clicked, find the frontmost Shape in the drawing
   * that contains the mouse position. If there is such a Shape, then
   * if this is the first click in the pair of clicks (indicated by
   * firstShape being null), save it in firstShape. Otherwise, exchange
   * the centers of this newly clicked Shape and firstShape.
   * 
   * @param p the coordinates of the click
   * @param dwg the drawing being clicked
   */
  public void executeClick(Point p, Drawing dwg) {
    // Find the frontmost shape containing p.
    s = dwg.getFrontmostContainer(p);
    
    if (s != null) { // was there a Shape containing p?
      if (firstShape == null) {
        firstShape = s; // save this Shape for when there's another click
        s1 = firstShape;
      }
      else {
        // We have two Shapes to exchange. Get their centers.
        firstCenter = firstShape.getCenter();
        secondCenter = s.getCenter();

        // Exchange their centers.
        firstShape.setCenter(secondCenter);
        s.setCenter(firstCenter);

        // Now we get to start all over.
        firstShape = null;
      }
    }
  }
  
  /**
   * Undo the exchange operation
   */
  public void undo() {
	  s1.setCenter(firstCenter);
	  s.setCenter(secondCenter);
  }
}
