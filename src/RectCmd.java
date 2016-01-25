import java.awt.Point;

/**
 * RectangleCmd.java
 * Command class to perform drawing a rectangle command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class RectCmd extends Command{
	private Rect newRect;
	
	/**
	 * When the mouse is 
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) {
		newRect = new Rect(dwg.getColor());
		dwg.addShape(newRect);
	 }
	
	/**
	 * When the mouse is pressed, the 
	 * @param p
	 * @param dwg
	 */
	 public void executePress(Point p, Drawing dwg) { }
	 public void executeDrag(Point p, Drawing dwg) { }

}
