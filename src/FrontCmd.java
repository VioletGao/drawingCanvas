import java.awt.Point;

/**
 * FrontCmd.java
 * Command class to perform a front command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class FrontCmd extends Command {

	private Shape movedShape;
	
	/**
	 * When the mouse is clicked, find the frontmost object 
	 * that is under the mouse position at the time of the click,
	 * move it to the front of the linear ordering of objects in the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		movedShape = dwg.getFrontmostContainer(p);
		if (movedShape != null) {
			dwg.moveFront(movedShape);
		}
	}
}
