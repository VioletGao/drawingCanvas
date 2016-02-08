import java.awt.Color;
import java.awt.Point;

/**
 * ColorCmd.java
 * Command class to perform a color command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class ColorCmd extends UndoableCommand {
	private Shape s; // the shape clicked to change its color
	private Color c; // color of the shape before doing the operation
	
	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * the color of that Shape is changed to the current default color
	 * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) { 
		s = dwg.getFrontmostContainer(p);
		c = s.getColor();

		if (s != null) { 
			s.setColor(dwg.getColor());
		}
	}
	
	/**
	 * Undo the change of the color
	 */
	public void undo() {
		if (s != null) {
			s.setColor(c);
		}
	}
}
