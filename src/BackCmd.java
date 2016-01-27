import java.awt.Point;

/**
 * BackCmd.java
 * Command class to perform a back command.
 * 
 * @author Yuan Gao
 * @see Command
 */
public class BackCmd extends Command{

	private Shape movedShape;
	
	/**
	 * When the mouse is clicked, find the frontmost object 
	 * that is under the mouse position at the time of the click,
	 * move it to the back of the linear ordering of objects in the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		movedShape = dwg.getFrontmostContainer(p);
		if (movedShape != null) {
			dwg.moveBack(movedShape);
		}
	}

}
