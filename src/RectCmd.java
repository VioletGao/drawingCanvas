import java.awt.Point;

/**
 * RectangleCmd.java
 * Command class to perform an adding rectangle command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class RectCmd extends Command{	
	private Rect newRect;
	
	/**
	 * When the mouse is pressed, a new rectangle is added to the drawing
	 * on the location of the mouse
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 newRect = new Rect(dwg.getColor());
		 newRect.getStartPoint(p);
		 dwg.addShape(newRect);
	}

	/**
	 * When the mouse is dragged, the new position of the mouse is recorded continuously
	 * 
	 * @param p the current position of the mouse
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newRect.updatePos(p);
	}

}
