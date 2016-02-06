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
	private Point pressedPoint;	// where the mouse was pressed
	
	/**
	 * When the mouse is pressed, a new rectangle is added to the drawing
	 * on the location of the mouse
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 newRect = new Rect(dwg.getColor());
		 pressedPoint = p;
		 dwg.addShape(newRect);	
		 newRect.setX(p.x);
		 newRect.setY(p.y);
		 newRect.setWidth(0);
		 newRect.setHeight(0);
	}

	/**
	 * When the mouse is dragged, the new position of the mouse is recorded continuously
	 * 
	 * @param p the current position of the mouse
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		 newRect.setX(Math.min(p.x, pressedPoint.x));
		 newRect.setY(Math.min(p.y, pressedPoint.y));
		 newRect.setWidth(Math.abs(p.x - pressedPoint.x));
		 newRect.setHeight(Math.abs(p.y - pressedPoint.y));
	}

}
