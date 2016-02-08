import java.awt.Point;

/**
 * ReshapeCmd.java
 * Command class to perform a reshape command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class ReshapeCmd extends UndoableCommand {

	Shape s; // the shape to be reshaped
	
	/**
	 * When the mouse is pressed, find the frontmost Shape in the drawing
     * that contains the mouse position.
     * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executePress(Point p, Drawing dwg) {
		s = dwg.getFrontmostContainer(p);
	}
	
	/**
	 * Reshape the shape got pressed
	 * 
	 * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeDrag(Point p, Drawing dwg) { 
		if (s != null) {
			s.reshape(p);
		}
	}
	
}
