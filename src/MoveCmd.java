import java.awt.*;

/**
 * MoveCmd.java
 * Command class to perform a move command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class MoveCmd extends UndoableCommand {
	private Point curPoint; // the point where the mouse current located
	private Shape s; // the shape to be moved
	private Point initalPoint; // the point where mouse first clicked
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then 
	 * that shape is moved with the position of the mouse.
	 * 
	 * @param p the coordinates of the press
     * @param dwg the drawing being pressed
	 */
	public void executePress(Point p, Drawing dwg) {
		s = dwg.getFrontmostContainer(p);
		curPoint = p;
		initalPoint = p;
	}
	
	/**
	 * When the mouse is dragged, the new position of mouse is recorded continuously
	 * 
	 * @param p the coordinates of the place where mouse last locate
     * @param dwg the drawing being dragged
	 */
	public void executeDrag(Point p, Drawing dwg) {
		int x = p.x - curPoint.x;
		int y = p.y - curPoint.y;
		
		if (s != null) {
			s.move(x,y);
		}
		
		curPoint = p;
	}
	
	/**
	 * Undo the last move operation
	 */
	public void undo() {
		int x = initalPoint.x - curPoint.x;
		int y = initalPoint.y - curPoint.y;
		if (s != null) {
			s.move(x, y);
		}
	}
}
