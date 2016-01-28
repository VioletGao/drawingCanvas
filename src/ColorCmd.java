import java.awt.Point;

/**
 * ColorCmd.java
 * Command class to perform a color command.
 * 
 * Written by YG for CSC260 Project1.
 * @author Yuan (Violet) Gao
 * @see Command
 */
public class ColorCmd extends Command {
	private Shape colorChangeShape; // the shape clicked to change its color
	
	/**
	 * When the mouse is clicked, find the frontmost Shape in the drawing
	 * that contains the mouse position. If there is such a Shape, then
	 * the color of that Shape is changed to the current default color
	 * 
     * @param p the coordinates of the click
     * @param dwg the drawing being clicked
	 */
	public void executeClick(Point p, Drawing dwg) { 
		// Find the frontmost shape containing p
		colorChangeShape = dwg.getFrontmostContainer(p);
		
		if (colorChangeShape != null) { // was there a Shape containing p?
			colorChangeShape.setColor(dwg.getColor());
		}
	}
}
