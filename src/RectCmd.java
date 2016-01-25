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
	 * @param p the coordinates of the click
	 * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		 newRect = new Rect(dwg.getColor());
		 newRect.getStartPoint(p);
		 dwg.addShape(newRect);
	}

	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * @param p
	 * @param dwg
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newRect.updatePos(p);
	}

}
