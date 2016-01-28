import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class MoveCmd extends Command {
	private Point lastPoint; // the point where the mouse last located
	private Shape movedShape; // the shape to be moved
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then 
	 * that shape is moved with the position of the mouse.
	 * 
	 * @param p the coordinates of the press
     * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		movedShape = dwg.getFrontmostContainer(p);
		lastPoint = p;
	}
	
	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * 
	 * @param p the coordinates of the place where mouse last locate
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
