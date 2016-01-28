import java.awt.Point;

/**
 * EllipseCmd.java
 * Command class to perform an adding Ellipse command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class EllipseCmd extends Command{
	private Ellipse newEllipse;
	
	/**
	 * When the mouse is pressed, a new Ellipse is added into the drawing
	 * 
	 * @param p the coordinates of the place which is pressed
	 * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		 newEllipse = new Ellipse(dwg.getColor());
		 
		 newEllipse.getStartPoint(p);
		 dwg.addShape(newEllipse);
	}
	
	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * 
	 * @param p the coordinates of the place where mouse last locate
	 * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		newEllipse.updatePos(p);
	}
}
