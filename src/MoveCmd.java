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
		movedShape.move(x,y);
		lastPoint = p;
	}
}
