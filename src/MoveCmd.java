import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform an move command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class MoveCmd extends Command {
	private Point lastPoint; // the point where the mouse last located
	private Shape movedShape; // the shape being removed
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then that
	 * shape is moved with the position of the mouse.
	 * 
	 * @param p the coordinates of the press
     * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		movedShape = dwg.getFrontmostContainer(p);
		lastPoint = p;
	}
	
	/**
	 * When the mouse is dragged
	 * @param p the coordinates of the mouse last locate
     * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		int x = p.x - lastPoint.x;
		int y = p.y - lastPoint.y;
		if (movedShape != null) {
			movedShape.move(x,y);
		}
		lastPoint = p;
	}
}
